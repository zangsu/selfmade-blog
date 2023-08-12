package com.example.selfmadeBlog.DAO;

import java.sql.*;
import java.util.function.Function;

public class DAOContext implements DAOInterface{

    private static DAOContext daoContext = null;
    private static final String url = DAOConfig.URL;
    private static final String userName = DAOConfig.USERNAME;
    private static final String password = DAOConfig.PASSWORD;

    private DAOContext() {}

    public static DAOContext getDaoContext() {
        if(daoContext == null)
            daoContext = new DAOContext();
        return daoContext;
    }

    @Override
    public int executeSQLAndReturn(String sql, String... args) {
        int generatedKey = 0;
        try (Connection conn = getConnect()) {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for(int i = 0; i<args.length; i++){
                ps.setString(i+1, args[i]);
            }
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedKey =  rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedKey;
    }

    @Override
    public <R, I> R getObject(String sql, Function<ResultSet, R> mapper, I identifier) {

        R returnObject = null;
        try (Connection conn = getConnect()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, identifier.toString());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                returnObject = mapper.apply(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return returnObject;
    }

    public Connection getConnect() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
}
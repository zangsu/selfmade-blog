package com.example.selfmadeBlog.DAO;

import com.example.selfmadeBlog.exception.database.NoDataFoundedException;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.function.Function;

@Repository
public class DAOContext implements DAOInterface{

    private static final String url = DAOConfig.URL;
    private static final String userName = DAOConfig.USERNAME;
    private static final String password = DAOConfig.PASSWORD;



    @Override
    public int executeSQLAndReturn(String sql, String... args) throws SQLException {
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
        }

        return generatedKey;
    }

    @Override
    public <R, I> R getObject(String sql, Function<ResultSet, R> mapper, I identifier) throws SQLException {

        R returnObject = null;
        try (Connection conn = getConnect()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, identifier.toString());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                returnObject = mapper.apply(rs);
            }else{
                throw new NoDataFoundedException();
            }
        }
        return returnObject;
    }

    @Override
    public void update(String sql, String... args) throws SQLException {
        try (Connection conn = getConnect()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setString(i+1, args[i]);
            }

            ps.executeUpdate();
        }
    }

    @Override
    public void delete(String sql, String identifier) throws SQLException {
        try(Connection conn = getConnect()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, identifier);

            ps.executeUpdate();
        }
    }


    public Connection getConnect() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
}

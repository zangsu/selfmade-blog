package com.example.selfmadeBlog.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

public interface DAOInterface {
    int executeSQLAndReturn(String sql, String... args) throws SQLException;
    <R, I> R getObject(String sql, Function<ResultSet, R> mapper, I identifier) throws SQLException;
    void update(String sql, String... args) throws SQLException;
    void delete(String sql, String identifier) throws SQLException;
}

package com.example.selfmadeBlog.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

public interface DAOInterface {
    public int executeSQLAndReturn(String sql, String... args);
    public <R, I> R getObject(String sql, Function<ResultSet, R> mapper, I identifier);
}

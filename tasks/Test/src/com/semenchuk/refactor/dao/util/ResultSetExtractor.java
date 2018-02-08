package com.semenchuk.refactor.dao.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetExtractor<T> {
    T extractData(ResultSet resultSet) throws SQLException;
}
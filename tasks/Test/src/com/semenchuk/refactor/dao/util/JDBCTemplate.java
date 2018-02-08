package com.semenchuk.refactor.dao.util;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class JDBCTemplate {
    private DataSource dataSource;

    public JDBCTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int update(String sql, Object... objects) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            int rowNum = 1;
            for (Object object : objects) {
                statement.setObject(rowNum++, object);
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            System.err.print("Cannot update objects " + e);
            return 0;
        }
    }


    public Long insert(String sql, Object... objects) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            return insert(statement, objects);
        } catch (SQLException e) {
            System.err.print("Cannot insert objects " + e);
            return 0L;
        }
    }


    public <T> List<T> queryForList(String sql, ResultSetExtractor<T> resultSetExtractor, Object... objects) {
        return (List<T>) queryForCollection(new ArrayList<>(), sql, resultSetExtractor, (Object[]) objects);
    }

    private <T> Collection<T> queryForCollection(Collection<T> collection, String sql,
                                                 ResultSetExtractor<T> resultSetExtractor, Object... objects) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            int rowNum = 1;
            for (Object object : objects) {
                statement.setObject(rowNum++, object);
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                collection.add(resultSetExtractor.extractData(resultSet));
            }
            return collection;
        } catch (SQLException e) {
            System.err.print("Cannot read objects " + e);
        }
        return collection;
    }

    public <T> Set<T> queryForSet(String sql, ResultSetExtractor<T> resultSetExtractor, Object... objects) {
        return (Set<T>) queryForCollection(new HashSet<>(), sql, resultSetExtractor, (Object[]) objects);
    }

    private Long insert(PreparedStatement statement, Object... objects) {
        int rowNum = 1;
        try {
            for (Object object : objects) {
                statement.setObject(rowNum++, object);
            }
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
        } catch (SQLException e) {
            System.err.print("Cannot insert object " + e);
        }
        return 0L;
    }

    public <T> T queryWithParameters(String sql, ResultSetExtractor<T> resultSetExtractor, Object... objects) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            int rowNum = 1;
            for (Object object : objects) {
                statement.setObject(rowNum++, object);
            }
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSetExtractor.extractData(resultSet);
            }
        } catch (SQLException e) {
            System.err.print("Cannot read object " + e);
        }
        return null;
    }
}

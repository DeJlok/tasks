package com.semenchuk.refactor.dao;


import oracle.jdbc.pool.OracleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by MrWhite_PRO on 04.02.2018.
 */
public class DataSourceSingleton {
    private static DataSource dataSource;
    private static final String USER = "admin";
    private static final String DATA_SOURCE_NAME = "source";
    private static final String PASSWORD = "beefhead";
    private static final String DATA_BASE_NAME = "prod";
    private static final String SERVER_NAME = "localhost:1521";

    private DataSourceSingleton() {
    }

    public static DataSource getInstance() {
        if (dataSource == null) {
            try {
                dataSource = setUpDataSource();
            } catch (SQLException e) {
                System.err.print("Can not set up data source" + e);
            }
        }
        return dataSource;
    }

    private static DataSource setUpDataSource() throws SQLException {

        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setDataSourceName(DATA_SOURCE_NAME);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setDatabaseName(DATA_BASE_NAME);
        dataSource.setServerName(SERVER_NAME);
        return dataSource;
    }
}

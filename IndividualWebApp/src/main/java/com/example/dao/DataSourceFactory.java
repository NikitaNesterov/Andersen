package com.example.dao;


import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataSourceFactory {
    private final DataSource dataSource;
    private static final Logger LOGGER = Logger.getLogger(DataSourceFactory.class.getName());

    public DataSourceFactory() {
        MysqlDataSource dataSource = new MysqlDataSource();
        String rootpath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("database.properties").getPath());
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(rootpath);
            Properties properties = new Properties();
            properties.load(inputStream);
            dataSource.setDatabaseName(properties.getProperty("database"));
            dataSource.setServerName(properties.getProperty("serverName"));
            dataSource.setPort(Integer.parseInt(properties.getProperty("port")));
            dataSource.setUser(properties.getProperty("user"));
            dataSource.setPassword(properties.getProperty("password"));
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "File database.properties Not Found", e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "IO Error", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LOGGER.log(Level.SEVERE, "Failed to close InputStream", e);
                }
            }
        }
        this.dataSource = dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return SingletonHelper.INSTANCE.dataSource.getConnection();
    }

    public static class SingletonHelper {
        private static final DataSourceFactory INSTANCE = new DataSourceFactory();
    }


}

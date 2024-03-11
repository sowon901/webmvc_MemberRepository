package com.ssg.member.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public enum ConnectionUtil {
    Instance;

    private HikariDataSource hd;


    ConnectionUtil() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3307/mvc_member");
        config.setUsername("member");
        config.setPassword("member");
        config.addDataSourceProperty("cachePrepStmts","true");
        config.addDataSourceProperty("prepStmtCacheSize","250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit","2048");

        hd = new HikariDataSource(config);
    }

    public Connection getConnection() throws Exception {
        return hd.getConnection();  //Connection.INSTANCE.getConnection();
    }

}
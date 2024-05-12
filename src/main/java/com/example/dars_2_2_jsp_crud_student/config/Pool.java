package com.example.dars_2_2_jsp_crud_student.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;

public class Pool {
    @Getter
    private static final HikariDataSource dataSource;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HikariConfig config=new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/jspDB");
        config.setUsername("postgres");
        config.setPassword("7577714");
        config.setMinimumIdle(5);
        config.setMaximumPoolSize(10);
        config.setConnectionTimeout(30000);
        dataSource=new HikariDataSource(config);
    }
}

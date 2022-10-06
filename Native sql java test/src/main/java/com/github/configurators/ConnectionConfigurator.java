package com.github.configurators;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ConnectionConfigurator {
    @Bean
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost/Electronics_store", "postgres", "12345");
        } catch (SQLException e) {
            System.out.println("Log");
            return null;
        }
    }
}

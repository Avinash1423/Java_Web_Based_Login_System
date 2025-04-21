package com.peace.login_system_3.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbCon {

    private static String url;
    private static String name;
    private static String password;



    static {
        Properties props=new Properties();
        InputStream input = DbCon.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            props.load(input);

            url=props.getProperty("db.url");
            name=props.getProperty("db.username");
            password=props.getProperty("db.password");
            Class.forName("oracle.jdbc.OracleDriver");

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws Exception{

        return DriverManager.getConnection(url,name,password);
   
    }



}



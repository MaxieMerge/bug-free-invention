package com.bug.free.invention.api.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

    private  static String Username = "teamCadmin";
    private static String Password = "teampassword" ;
    private static String host = "academy2020.cpc8rvmbbd9k.eu-west-2.rds.amazonaws.com";

    public DBConfig(){

    }

    public static Connection getConnection(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://"+ host + "/teamC_Josh?useSSL=false", Username, Password);
            return conn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}

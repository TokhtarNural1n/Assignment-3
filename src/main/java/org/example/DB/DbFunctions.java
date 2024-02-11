package org.example.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbFunctions implements IDbFunctions{

    public Connection getConnection(){
        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "0000");

            return con;

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}

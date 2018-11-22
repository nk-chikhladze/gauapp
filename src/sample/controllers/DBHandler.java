package sample.controllers;

import java.sql.*;
//import java.util.TimeZone;

import sample.Configs.Config;
import sample.Configs.Constants;

public class DBHandler extends Config {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;

//        String select = "SELECT * FROM " + Constants.USER_TABLE;
//        String select = "SELECT * FROM " + Constants.USER_TABLE + " WHERE " + Constants.USERS_USERNAME + "=? AND " + Constants.USERS_PASSWORD + "=?";

        try {
//            PreparedStatement prSt = getDbConnection().prepareStatement(select);


//            prSt.setString(0, "secret");
//            prSt.setString(1, user.getUsername());
//            prSt.setString(2, user.getPassword());
//            prSt.setString(3, user.getPermission());
//            System.out.println("We here");

            Statement stmt = null;
            stmt = getDbConnection().createStatement();
            String sql = "SELECT * FROM Users";
            resSet = stmt.executeQuery(sql);

//            while(resSet.next()){
//                int id  = resSet.getInt("id");
//                String userr = resSet.getString("username");
//                String pass = resSet.getString("password");
//                int perm = resSet.getInt("permission");
//
//                //Display values
//                System.out.print("ID: " + id);
//                System.out.print(", user: " + userr);
//                System.out.print(", pass: " + pass);
//                System.out.println(", perm: " + perm);
//            }

//            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }
}

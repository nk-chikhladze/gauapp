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

    public ResultSet getFullUser(User user) {
        ResultSet resSet = null;

        try {

            Statement stmt = null;
            stmt = getDbConnection().createStatement();
            String sql = "SELECT * FROM Users";
            resSet = stmt.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }

    public ResultSet getLogin(User user){
        ResultSet resSet = null;

        try {

            Statement stmt = null;
            stmt = getDbConnection().createStatement();
            String sql = "SELECT username,password,permission FROM Users";
            resSet = stmt.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }

    public void registerUser(User user){
        String username,password;


        username = user.getUsername();
        password = user.getPassword();

        String insert = "INSERT INTO " +
                    Constants.USER_TABLE +
                    "(" +
                    Constants.USERS_USERNAME + "," +
                    Constants.USERS_PASSWORD + "," +
                    Constants.USERS_PERMISSION +
                    ")" +
                    "VALUES(?,?," + 0 + ")";

            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(insert);
                prSt.setString(1, user.getUsername());
                prSt.setString(2, user.getPassword());

                prSt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


    }
}

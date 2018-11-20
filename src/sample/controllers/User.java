package sample.controllers;

public class User {
    private String firstname;
    private String lastname;
    private String location;
    private String gender;

    private String username;
    private String password;
    private String permission;

    //login constructor
    public User(String username, String password, String permission){
        this.username = username;
        this.password = password;
        this.permission = permission;

    }

    //full constructor
    public User(String firstname, String lastname, String username, String password, String location, String gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.location = location;
        this.gender = gender;
    }

    //empty constructor
    public User() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) { this.permission = permission; }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

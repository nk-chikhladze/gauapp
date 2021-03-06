package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User {
    private String firstname;
    private String lastname;
    private String location;
    private String gender;
    private int id;
    private String username;
    private String password;
    private int permission;

    private static ObservableList<User> list = FXCollections.observableArrayList();


    //login constructor
    public User(String username, String password){
        this.username = username;
        this.password = password;
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

    //select constructor
    public User(int id, String usr, String pss, int perm){
        this.id = id;
        this.username = usr;
        this.password = pss;
        this.permission = perm;
    }

    public int getId(){ return id; }

    public void setId(int id){ this.id = id; }

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

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) { this.permission = permission; }

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

<<<<<<< HEAD
    public void fillTestData(){
        list.add(new User(getId(),getUsername(),getPassword(),getPermission()));
//        list.add(new User(2,"username2","password2",1));
//        list.add(new User(3,"username3","password3",0));

    }

    public ObservableList<User> getList(){ return list; }
=======
    public ObservableList<String> getList(){
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("id");
        list.add(getUsername());
        list.add(getPassword());
        list.add("permission");


        return list;
    }
>>>>>>> 0c43b9c3665284eb98f4c5f2e34df155d3d6e4f9


}

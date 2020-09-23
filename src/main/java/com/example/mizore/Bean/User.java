package com.example.mizore.Bean;


import java.util.Vector;

public class User {
    private int id;
    private String name;
    private String password;
    private int money;
    private Vector<Good> mygoods;
    private Vector<Order> myorders;

    @Override
    public String toString() {
        return "User{id:"+id+
                ",name:" + name + '\'' +
                ", password:" + password + '\'' +
                ", money:" +money + '\'' +
                '}';
    }

    public User() {
    }

    public User(String username, String password, int money) {
        this.name = username;
        this.password = password;
        this.money=money;
    }
    public User(int id,String username,String password,int money){
        this.id=id;
        this.name=username;
        this.password=password;
        this.money=money;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Vector<Good> getMygoods() {
        return mygoods;
    }

    public void setMygoods(Vector<Good> mygoods) {
        this.mygoods = mygoods;
    }

    public Vector<Order> getMyorders() {
        return myorders;
    }

    public void setMyorders(Vector<Order> myorders) {
        this.myorders = myorders;
    }
}

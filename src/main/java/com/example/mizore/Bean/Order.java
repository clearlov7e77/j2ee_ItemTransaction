package com.example.mizore.Bean;

public class Order {
    private int id;
    private String name;
    private int count;
    private String address;
    private String customer;
    private String seller;

    public Order() {
    }

    public Order(int id, String name, int count, String address, String customer, String seller) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.address = address;
        this.customer = customer;
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", address='" + address + '\'' +
                ", customer='" + customer + '\'' +
                ", seller='" + seller + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}

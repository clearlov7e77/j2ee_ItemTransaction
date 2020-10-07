package com.example.mizore.Bean;

public class Good {
    private String name;
    private int count;
    private String description;
    private String type;
    private int id;
    private  int price;
    private String seller;

 //   @Override
  //  public String toString(){
  //  }


    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }

    public Good() {
    }

    public Good(String name, int count, String description, String type, int id) {
        this.name = name;
        this.count = count;
        this.description = description;
        this.type = type;
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}

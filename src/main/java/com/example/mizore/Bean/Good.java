package com.example.mizore.Bean;

public class Good {
    private String name;
    private int count;
    private String description;
    private String type;
    private int id;

 //   @Override
  //  public String toString(){
  //  }

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
}

package com.sz.entity;

public class Wife {


    private Integer id;

    private String name;


    private Husband husband;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }


    @Override
    public String toString() {
        return "Wife{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

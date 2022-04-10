package com.company.models;

public class Driver {
    private int id;
    private String name;
    private String bus;

    public Driver() {
    }

    public Driver(int id, String name, String bus) {
        this.id = id;
        this.name = name;
        this.bus=bus;
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

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }


    @Override
    public String toString() {
        return id+"   |  "+name+"     |"+ bus +'\n';
    }
}

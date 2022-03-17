package edu.study.book.chapter6.interclass;

public abstract class Device {
    private String name;
    public abstract double getPrice();

    public Device(String name) {
        this.name = name;
    }

    public Device() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

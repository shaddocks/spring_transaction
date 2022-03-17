package edu.study.book.chapter6.abstractfile;

public abstract class Shape {
    private String color;

    static {
        System.out.println("Shape的静态初始化块");
    }
    {
        System.out.println("Shape的初始化块");
    }

    public Shape(){}

    public Shape(String color){
        System.out.println("执行shape的构造器");
        this.color = color;
    }
    public abstract double calPerimeter();

    public abstract String getType();
}

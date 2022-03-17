package edu.study.book.chapter6.abstractfile;

public class TestAbstract {
    public static void main(String[] args){
        Shape triangle = new Triangle("black", 4.0, 3.0, 5.0);
        Shape circle = new Circle("red", 2.5);
        System.out.println(triangle.calPerimeter());
        System.out.println(circle.calPerimeter());
    }
}

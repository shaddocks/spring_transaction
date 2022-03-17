package edu.study.book.chapter6.interclass;

public class OuterClass {
    //psvm

    private double weight;

    public OuterClass(){}
    public OuterClass(double weight){
        this.weight = weight;
    }

    public class InterClass{
        private double length;
        private String color;
        private double weight = 0;

        public InterClass(){}

        public InterClass(double length, String color) {
            this.length = length;
            this.color = color;
        }

        public void info(){
            System.out.println("外部类的成员变量: " + OuterClass.this.weight);
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    public static class InterStaticClass{
        public static int p1 = 1;
        public int p2 = 2;
    }

    public void test(){
        InterClass interClass = new InterClass(1.12, "白色");
        interClass.info();
    }

    public static void main(String[] args) {
        new OuterClass(11).test();
        OuterClass.InterClass interClass = new OuterClass(12).new InterClass(1.1, "12");
    }
}

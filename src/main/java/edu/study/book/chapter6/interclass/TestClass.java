package edu.study.book.chapter6.interclass;

public class TestClass {

    public double p = 12.3;
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass(12);
        OuterClass.InterClass abc = outerClass.new InterClass(1.1, "abc");
        System.out.println(abc.getColor());
        OuterClass.InterStaticClass interStaticClass = new OuterClass.InterStaticClass();

        TestClass testClass = new TestClass();
        testClass.test(new Product() {
            double a = 12;
            {

            }
            @Override
            public double getPrice() {
                return 567.8;
            }

            @Override
            public String getName() {
                return "abc";
            }
        });

        testClass.test1(new Device("电子显示器") {
            @Override
            public double getPrice() {
                return 67.8;
            }
        });
    }

    public void test1(Device device){
        System.out.println(device.getName() + "  " + device.getPrice());
    }

    public void test(Product product){
        System.out.println(product.getName() + "  " + product.getPrice());
    }
}

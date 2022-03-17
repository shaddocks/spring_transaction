package edu.study.book.chapter6;

public class ClassTest {
    public static void main(String[] args){
        for (int i = 0; i < 5; ++i){
            System.out.println("外层循环" + i);
            for (int j = 0; j < 5; ++j){
                System.out.print("内层循环" + j + " ");
            }
            System.out.println("\n");
        }
        //test01();
    }

    public static void test01(){
         Integer a = 5;
         Integer b = 5;
         String c = "5";

        int d = Integer.valueOf(c);
        String s = String.valueOf(a);

        System.out.println(a == b);

        Integer e = 126;
        Integer f = 126;
        Double g = 126.0;
        System.out.println(Double.compare(e, f));
        System.out.println(e.equals(g));
        System.out.println("" + f);
    }
}

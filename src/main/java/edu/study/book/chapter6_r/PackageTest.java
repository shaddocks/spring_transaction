package edu.study.book.chapter6_r;

public class PackageTest {
    public static void main(String[] args) {
        test03();
    }

    public static void test01(){
        Integer a = Integer.valueOf("12");
        String b = String.valueOf(12);
        Integer c = 12;
        System.out.println(Integer.compare(a, c));
    }

    public static void test02(){
        FunctionMethod functionMethod = new FunctionMethod() {
            @Override
            public int compareTo(Object obj) {
                return 0;
            }
        };
        functionMethod.compareTo("1");
    }

    public static void test03(){
        FunctionMethod functionMethod = obj -> {System.out.println(obj); return 0;};
        for (int i = 0; i < 10; ++i){
            functionMethod.compareTo(i);
        }
    }
}

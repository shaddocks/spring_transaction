package edu.study.book.chapter6.lambda;

public class CommandTest {
    public static void main(String[] args) {
        System.out.println("第二次提交");
        System.out.println("hot-fix");
        System.out.println("hot-fix2");
        process(new int[]{1, 2, 3}, (int element)->{
            System.out.println(element);
        });
    }

    public static void process(int[] target, Command command){
        for (int i: target) {
            command.process(i);
        }
    }
}

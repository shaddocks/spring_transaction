package edu.study.book.chapter6.lambda;

public class CiteLambda {
    public static void main(String[] args) {
        Converter converter1 = from -> Integer.valueOf(from);
        System.out.println(converter1.convert("12"));
        Converter converter2 = Integer::valueOf;
        System.out.println(converter2.convert("12"));

    }
}

package edu.study.book.chapter6.enumfile;

public class EnumTest {
    public static void main(String[] args) {
        for (SeasonEnum seasonEnum: SeasonEnum.values()){
            System.out.println(seasonEnum);
        }
        new EnumTest().judge(SeasonEnum.SPRING);
    }

    public void judge(SeasonEnum season){
        switch (season) {
            case SPRING:
                System.out.println("春");
                break;
            case SUMMER:
                System.out.println("夏");
                break;
            case FALL:
                System.out.println("秋");
                break;
            case WINTER:
                System.out.println("冬");
                break;
        }
    }
}

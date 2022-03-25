package edu.study.book.chapter6.enumfile;
import edu.study.book.chapter6.lambda.Command;

public enum SeasonEnum implements Command{
    SPRING("春"){
        @Override
        public void process(int target) {
            System.out.println(target + "春");
        }
    }, SUMMER("夏"){
        @Override
        public void process(int target) {
            System.out.println(target + "夏");
        }
    }, FALL("秋"){
        @Override
        public void process(int target) {
            System.out.println(target + "秋");
        }
    }, WINTER("冬"){
        @Override
        public void process(int target) {
            System.out.println(target + "冬");
        }
    };
    private final String name;

    SeasonEnum(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


}

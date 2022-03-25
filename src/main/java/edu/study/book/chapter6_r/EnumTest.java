package edu.study.book.chapter6_r;

public enum EnumTest implements EnumImplement{

    SPRING("1"){
        @Override
        public boolean testEnum(Object obj) {
            return false;
        }
    }, SUMMER("1") {
        @Override
        public boolean testEnum(Object obj) {
            return false;
        }
    }, FALL("3") {
        @Override
        public boolean testEnum(Object obj) {
            return false;
        }
    }, WINTER("4") {
        @Override
        public boolean testEnum(Object obj) {
            return false;
        }
    };

    private final String description;

    EnumTest(String description){
        this.description = description;
    }
}

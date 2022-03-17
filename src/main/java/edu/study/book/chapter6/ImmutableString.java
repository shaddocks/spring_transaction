package edu.study.book.chapter6;

import java.util.Objects;

public class ImmutableString {
    private final String detail;
    private final String postCode;

    public ImmutableString(String detail, String postCode) {
        this.detail = detail;
        this.postCode = postCode;
    }

    public String getDetail() {
        return detail;
    }

    public String getPostCode() {
        return postCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImmutableString)) return false;
        ImmutableString that = (ImmutableString) o;
        return detail.equals(that.detail) && postCode.equals(that.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detail, postCode);
    }

    public static void main(String[] args){
        System.out.println(new ImmutableString("12", "12").equals(new ImmutableString("12", "12")));
    }
}

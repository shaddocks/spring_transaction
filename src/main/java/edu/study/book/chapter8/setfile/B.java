package edu.study.book.chapter8.setfile;

import java.util.Objects;

public class B implements Comparable{
    private int id;

    public B() {
    }

    public B(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Object o) {
        B r = (B)o;
        return id > r.id? 1: id < r.id? -1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof B)) return false;
        B b = (B) o;
        return id == b.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "B{" +
                "id=" + id +
                '}';
    }
}

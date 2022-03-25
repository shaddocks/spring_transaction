package edu.study.book.chapter15;

import java.io.File;
import java.io.IOException;

public class FileTest {

    public static void main(String[] args) throws IOException {
        test02();
    }

    public static void test01() throws IOException {
        File file = new File("test.txt");
        file.renameTo(new File("newFile.txt"));
        if (!file.exists())file.createNewFile();
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
    }

    public static void test02(){
        File file = new File(".");
        String[] list = file.list(((dir, name) -> name.endsWith(".java") || new File(name).isDirectory()));
        for (String name: list){
            System.out.println(name);
        }
    }

}

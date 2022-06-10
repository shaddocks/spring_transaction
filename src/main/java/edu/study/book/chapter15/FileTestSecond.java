package edu.study.book.chapter15;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileTestSecond {
    public static void main(String[] args) {
        // System.out.println(System.getProperty("user.dir"));
        test09();
    }

    public static void test01() { // File对象的使用
        File file = new File(".");
        System.out.println(file.getName());
        System.out.println(file.getPath());//一些文件或者目录的操作
    }

    public static void test02() { // 文件过滤
        File file = new File(".");
        String[] fileName = file.list(((dir, name) -> new File(name).isDirectory() || name.endsWith(".txt")));
        for (String name: fileName) {
            System.out.println(name);
        }
    }

    public static void test03() { // FileInputStream FileReader 节点输入流
        try (final FileInputStream fileInputStream = new FileInputStream("newFile.txt")) {
            byte[] buffer = new byte[1024];
            int hasRead = 0;
            while ((hasRead = fileInputStream.read(buffer)) > 0) {
                System.out.println(new String(buffer, 0, hasRead));
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void test04() { // FileOutputStream FileWriter 节点输出流
        try (final FileOutputStream fileOutputStream = new FileOutputStream("writeFile.txt")) {
            byte[] bytes = "hello world".getBytes(StandardCharsets.UTF_8);
            fileOutputStream.write(bytes);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void test05() { // PrintStream 处理流
        try (final FileOutputStream fileOutputStream = new FileOutputStream("writeFile.txt");
             final PrintStream printStream = new PrintStream(fileOutputStream)) {
            printStream.println("new hello world");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void test06() {  // 转换流 缓冲流
        try (final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             final BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("exit")) return;
                System.out.println(line);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void test07() {
        InputStream reader = System.in;
        try {
            System.out.println(reader.read());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void test08() {  // 重定向标准输入输出
        PrintStream writer = System.out;
        try (final PrintStream printStream = new PrintStream(new FileOutputStream("writeFile.txt"))){
            System.setOut(printStream);
            System.out.println("普通字符串");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            System.setOut(writer);
        }
    }

    public static void test09() {
        try (final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("writeFile.txt"))) {
            objectOutputStream.writeObject(new Person("hello", 12));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try (final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("writeFile.txt"))) {
            Person person = (Person) objectInputStream.readObject();
            System.out.println(person.getName() + " " + person.getAge());
        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }
    }
}

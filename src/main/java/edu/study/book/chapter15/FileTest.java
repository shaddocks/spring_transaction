package edu.study.book.chapter15;

import java.io.*;
import java.util.Scanner;

public class FileTest {

    public static void main(String[] args) throws IOException {
        test07();
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

    public static void test03() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("newFile.txt");
        byte[] bytes = new byte[1024];
        int hasRead = 0;
        while ((hasRead = fileInputStream.read(bytes)) > 0) {
            System.out.println(new String(bytes, 0, hasRead));
        }
        fileInputStream.close();
    }

    public static void test04(){
        try(
                FileInputStream fileInputStream = new FileInputStream("newFile.txt");
                FileOutputStream fileOutputStream = new FileOutputStream("writeFile.txt")
        ){
            byte[] bytes = new byte[32];
            int hasRead = 0;
            while ((hasRead = fileInputStream.read(bytes)) > 0){
                fileOutputStream.write(bytes, 0, hasRead);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test05(){
        try (
                final FileOutputStream fileOutputStream = new FileOutputStream("writeFile.txt");
                final PrintStream printStream = new PrintStream(fileOutputStream);
        ){
            printStream.println("hello world\r\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void test06(){
        try (
                final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                //Reader a = inputStreamReader;
                final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ){
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("exit"))break;
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test07(){
        InputStream in = System.in;
        PrintStream out = System.out;
        System.out.write(98);
        try (
                final PrintStream printStream = new PrintStream(new FileOutputStream("writeFile.txt"));
                final FileInputStream fileInputStream = new FileInputStream("newFile.txt");
        ){
            System.setOut(printStream);
            System.out.println("hello world");

            System.setIn(fileInputStream);
            System.setOut(out);
            final Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            while (scanner.hasNext()){
                System.out.println(scanner.next());
            }
            System.setIn(in);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

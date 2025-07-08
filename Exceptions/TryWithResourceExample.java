package Exceptions;

import java.io.*;

public class TryWithResourceExample {

    public static void main(String[] args) {
        // Viết thử một file input
        createSampleFile("input.txt");

        // Đọc file bằng try-with-resources
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Đọc dòng: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Ở đây br sẽ tự động được đóng, kể cả khi exception xảy ra!

        // Ghi file bằng try-with-resources
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            bw.write("Xin chào, đây là file được ghi bằng try-with-resources!\n");
            bw.write("Dễ dàng và an toàn hơn try-finally.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // bw cũng tự đóng

        System.out.println("Hoàn thành chương trình.");
    }

    // Tạo file mẫu để đọc
    private static void createSampleFile(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("Dòng 1: Hello\n");
            bw.write("Dòng 2: Try-with-resources\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


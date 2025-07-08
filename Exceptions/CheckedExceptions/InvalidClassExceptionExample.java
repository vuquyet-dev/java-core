package Exceptions.CheckedExceptions;

import java.io.*;

/**
 * 📝 InvalidClassException:
 * - Là một checked exception trong Java.
 * - Xảy ra khi có sự không tương thích giữa lớp hiện tại và lớp đã được serialize trước đó.
 * - Thường do thay đổi serialVersionUID hoặc thay đổi cấu trúc lớp (field) sau khi ghi/đọc đối tượng.
 */
public class InvalidClassExceptionExample {
    public static void main(String[] args) {
        String filename = "student.ser";

        // 📌 Serialize đối tượng Student vào file student.ser
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            Student student = new Student("Alice", 20);
            oos.writeObject(student);
            System.out.println("Ghi thành công đối tượng Student vào file.");

        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }

        // 📌 Đọc lại đối tượng Student từ file student.ser
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Student student = (Student) ois.readObject();
            System.out.println("Đọc thành công đối tượng: " + student);

        } catch (InvalidClassException e) {
            // 🛑 Lỗi InvalidClassException sẽ xảy ra nếu serialVersionUID hoặc cấu trúc lớp đã thay đổi
            System.out.println("Lỗi InvalidClassException: Lớp đã thay đổi không tương thích với dữ liệu được serialize!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}

class Student implements Serializable {
    // ⚠️ Đảm bảo serialVersionUID cố định; nếu thay đổi giá trị này sẽ dẫn đến InvalidClassException khi deserialize
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

package Exceptions.UncheckedExceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 📝 InputMismatchException:
 * - Là một runtime exception (unchecked exception) trong Java.
 * - Xảy ra khi nhập dữ liệu từ Scanner không khớp với kiểu dữ liệu mong đợi.
 * - Ví dụ: yêu cầu nhập số nguyên nhưng người dùng nhập chuỗi hoặc ký tự không phải số.
 */
public class InputMismatchExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập một số nguyên: ");

            // 🛑 Nếu người dùng nhập giá trị không phải số nguyên, sẽ ném InputMismatchException
            int number = scanner.nextInt();

            System.out.println("Số bạn vừa nhập là: " + number);

        } catch (InputMismatchException e) {
            // 📌 Bắt lỗi nhập sai kiểu dữ liệu, in thông tin chi tiết
            System.out.println("Lỗi InputMismatchException: Giá trị nhập không phải số nguyên!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc bình thường.");
    }
}

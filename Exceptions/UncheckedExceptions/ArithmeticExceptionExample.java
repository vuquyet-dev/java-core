package Exceptions.UncheckedExceptions;

/**
 * 📝 ArithmeticException:
 * - Là một runtime exception (unchecked exception) trong Java.
 * - Xảy ra khi thực hiện phép toán không hợp lệ về mặt số học, ví dụ:
 *     ⚠️ Chia một số nguyên cho 0 (integer division by zero).
 * - Lưu ý: Nếu chia số thực (double/float) cho 0 thì KHÔNG gây ra ArithmeticException,
 *          kết quả sẽ là Infinity hoặc NaN.
 */
public class ArithmeticExceptionExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 0; // ⚠️ Giá trị cố tình gán bằng 0 để gây ra lỗi chia cho 0

        try {
            // 🛑 Thực hiện phép chia. Vì b = 0 nên sẽ phát sinh ArithmeticException
            int result = a / b;

            // ⚠️ Dòng dưới sẽ không được thực thi nếu có lỗi xảy ra
            System.out.println("Kết quả: " + result);

        } catch (ArithmeticException e) {
            // 📌 Bắt lỗi chia cho 0 và in ra thông báo
            System.out.println("Lỗi ArithmeticException: Không thể chia cho 0!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc bình thường.");
    }
}

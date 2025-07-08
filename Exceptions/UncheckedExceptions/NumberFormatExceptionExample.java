package Exceptions.UncheckedExceptions;

/**
 * 📝 NumberFormatException:
 * - Là một runtime exception (unchecked exception) trong Java.
 * - Xảy ra khi cố gắng chuyển đổi (parse) một chuỗi (String) sang kiểu số (int, float, double,...) nhưng
 *   chuỗi không đúng định dạng số hợp lệ.
 * - Thường gặp khi:
 *     ⚠️ Nhập dữ liệu không phải số từ bàn phím, file, hoặc API.
 *     ⚠️ Dữ liệu chứa ký tự không hợp lệ cho số, ví dụ: "12abc", "1.2.3", "abc".
 */
public class NumberFormatExceptionExample {
    public static void main(String[] args) {
        String input = "123abc"; // ⚠️ Chuỗi không phải số hợp lệ

        try {
            // 🛑 Cố gắng chuyển đổi chuỗi sang số nguyên → phát sinh NumberFormatException
            int number = Integer.parseInt(input);

            // ⚠️ Dòng dưới sẽ không chạy nếu lỗi xảy ra
            System.out.println("Giá trị số nguyên: " + number);

        } catch (NumberFormatException e) {
            // 📌 Bắt lỗi NumberFormatException khi chuỗi không phải số hợp lệ
            System.out.println("Lỗi NumberFormatException: Chuỗi không phải là số hợp lệ!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc bình thường.");
    }
}

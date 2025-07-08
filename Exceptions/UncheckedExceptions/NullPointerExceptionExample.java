package Exceptions.UncheckedExceptions;

/**
 * 📝 NullPointerException:
 * - Là một unchecked exception (runtime exception) rất phổ biến trong Java.
 * - Xảy ra khi bạn cố gắng truy cập phương thức hoặc thuộc tính của một object đang null,
 *   hoặc truy cập phần tử mảng nhưng biến mảng lại null.
 * - Đây là lỗi logic thường gặp khi quên khởi tạo object trước khi sử dụng.
 */
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String str = null; // ⚠️ Biến str chưa được khởi tạo giá trị hợp lệ (bị gán null)

        try {
            // 🛑 Thực hiện gọi phương thức trên biến null => phát sinh NullPointerException
            int length = str.length();

            // ⚠️ Dòng dưới sẽ không chạy nếu có lỗi xảy ra
            System.out.println("Độ dài chuỗi: " + length);

        } catch (NullPointerException e) {
            // 📌 Bắt lỗi null pointer và in ra thông báo
            System.out.println("Lỗi NullPointerException: Đối tượng đang null!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc bình thường.");
    }
}

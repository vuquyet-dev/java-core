package Exceptions.UncheckedExceptions;

/**
 * 📝 StringIndexOutOfBoundsException:
 * - Là một runtime exception (unchecked exception) trong Java.
 * - Xảy ra khi truy cập chỉ số (index) không hợp lệ trên chuỗi (String).
 * - Nguyên nhân thường gặp:
 *     ⚠️ Chỉ số < 0 hoặc >= độ dài chuỗi.
 *     ⚠️ Truy cập ký tự vượt ngoài giới hạn chuỗi trong các phương thức như: charAt(), substring(),...
 */
public class StringIndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        String text = "Hello";

        try {
            // 🛑 Truy cập ký tự tại chỉ số 10 (chuỗi chỉ dài 5 ký tự) → phát sinh StringIndexOutOfBoundsException
            char ch = text.charAt(10);

            // ⚠️ Dòng dưới sẽ không chạy nếu lỗi xảy ra
            System.out.println("Ký tự ở chỉ số 10: " + ch);

        } catch (StringIndexOutOfBoundsException e) {
            // 📌 Bắt lỗi khi chỉ số nằm ngoài giới hạn
            System.out.println("Lỗi StringIndexOutOfBoundsException: Chỉ số vượt ngoài độ dài chuỗi!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc bình thường.");
    }
}

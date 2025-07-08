package Exceptions.Errors;

/**
 * 📝 ClassFormatError:
 * - Là một Error trong Java (không phải Exception).
 * - Xảy ra khi JVM nạp (load) một file .class nhưng phát hiện định dạng không hợp lệ.
 * - Nguyên nhân có thể là:
 *     ⚠️ File .class bị hỏng, chỉnh sửa thủ công, hoặc bị biên dịch lỗi.
 *     ⚠️ Class được biên dịch bằng compiler không tương thích với JVM đang chạy.
 * - Đây là lỗi nghiêm trọng, thường không thể bắt và xử lý được hợp lý trong ứng dụng.
 */
public class ClassFormatErrorExample {
    public static void main(String[] args) {
        try {
            // 🛑 Mô phỏng: ép ném ClassFormatError thủ công để minh họa
            // Thực tế: lỗi này xảy ra khi JVM nạp file .class không hợp lệ.
            throw new ClassFormatError("Giả lập lỗi ClassFormatError: File .class bị hỏng!");

        } catch (ClassFormatError e) {
            // 📌 Bắt lỗi và in ra thông báo (dù thực tế rất ít khi xử lý lỗi kiểu này)
            System.out.println("Lỗi ClassFormatError: Không thể nạp class!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc (dù lỗi ClassFormatError thường rất nghiêm trọng).");
    }
}

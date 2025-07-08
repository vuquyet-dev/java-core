package Errors;

/**
 * 📝 NoClassDefFoundError:
 * - Là một error (không phải exception) thuộc nhóm lỗi nghiêm trọng trong Java.
 * - Xảy ra khi JVM không thể tìm thấy definition của một class đã được tham chiếu trong code,
 *   mặc dù chương trình đã được biên dịch thành công.
 * - Nguyên nhân phổ biến: file .class bị xóa, bị di chuyển, hoặc không nằm trong classpath.
 * - Đây là lỗi liên quan đến môi trường runtime, không phải lỗi cú pháp hay logic.
 */
public class NoClassDefFoundErrorExample {
    public static void main(String[] args) {
        try {
            // 🛑 Tham chiếu tới một class khác mà nếu class đó không có trong classpath khi chạy,
            // JVM sẽ ném NoClassDefFoundError
            HelperClass.sayHello();

        } catch (NoClassDefFoundError e) {
            // 📌 Bắt lỗi để in ra thông báo
            System.out.println("Lỗi NoClassDefFoundError: Không tìm thấy class cần thiết khi chạy!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc bình thường.");
    }
}

// 🔹 Class phụ trợ (HelperClass) này cần tồn tại trong classpath khi chạy
class HelperClass {
    static void sayHello() {
        System.out.println("Xin chào từ HelperClass!");
    }
}

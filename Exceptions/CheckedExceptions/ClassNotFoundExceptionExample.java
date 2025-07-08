package Exceptions.CheckedExceptions;

/**
 * 📝 ClassNotFoundException:
 * - Là một checked exception trong Java.
 * - Xảy ra khi chương trình cố gắng nạp một lớp bằng tên (dạng chuỗi) nhưng lớp đó không tồn tại trên classpath.
 *     ⚠️ Thường gặp khi sử dụng Class.forName("TênLớp") trong JDBC, Reflection, v.v.
 * - Vì là checked exception, bắt buộc phải xử lý bằng try-catch hoặc khai báo throws.
 */
public class ClassNotFoundExceptionExample {
    public static void main(String[] args) {
        try {
            // 🛑 Cố gắng nạp một lớp không tồn tại. Ở đây dùng tên lớp giả "com.example.NonExistentClass"
            Class<?> clazz = Class.forName("com.example.NonExistentClass");

            // ⚠️ Dòng dưới sẽ không được thực thi nếu lỗi xảy ra
            System.out.println("Lớp nạp thành công: " + clazz.getName());

        } catch (ClassNotFoundException e) {
            // 📌 Bắt lỗi khi lớp không tồn tại, in thông báo lỗi
            System.out.println("Lỗi ClassNotFoundException: Không tìm thấy lớp được chỉ định!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc bình thường.");
    }
}

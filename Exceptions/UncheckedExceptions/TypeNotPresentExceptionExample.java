package Exceptions.UncheckedExceptions;

/**
 * 📝 TypeNotPresentException:
 * - Là một RuntimeException (unchecked exception) trong Java.
 * - Xảy ra khi JVM hoặc chương trình cố gắng tham chiếu đến một class theo tên,
 *   nhưng class đó không tồn tại trong classpath.
 * - Thường gặp trong reflection, generic type, hoặc khi xử lý annotation.
 */
public class TypeNotPresentExceptionExample {
    public static void main(String[] args) {
        try {
            String typeName = "com.example.NonExistentClass"; // ⚠️ Tên class không tồn tại

            // 🛑 Tự ném TypeNotPresentException để minh họa
            throw new TypeNotPresentException(typeName, new ClassNotFoundException("Class không tìm thấy!"));

        } catch (TypeNotPresentException e) {
            // 📌 Bắt TypeNotPresentException và in chi tiết
            System.out.println("Lỗi TypeNotPresentException!");
            System.out.println("Tên type không tồn tại: " + e.typeName());
            System.out.println("Nguyên nhân: " + e.getCause());
        }

        System.out.println("Chương trình kết thúc bình thường.");
    }
}

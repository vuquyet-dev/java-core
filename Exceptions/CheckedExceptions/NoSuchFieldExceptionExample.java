package Exceptions.CheckedExceptions;

import java.lang.reflect.Field;

/**
 * 📝 NoSuchFieldException:
 * - Là một checked exception trong Java.
 * - Xảy ra khi sử dụng Reflection để truy cập một field (biến) mà **không tồn tại** trong class.
 * - Thường gặp khi:
 *     ⚠️ Gọi Class.getDeclaredField("fieldName") hoặc Class.getField("fieldName")
 *         với tên field không đúng hoặc field đã bị xóa/thay đổi.
 * - Là một ngoại lệ quan trọng trong lập trình phản chiếu (reflection) hoặc thư viện phụ thuộc nhiều vào tên trường.
 */
public class NoSuchFieldExceptionExample {
    public static void main(String[] args) {
        try {
            // 🛑 Lấy class ví dụ
            Class<SampleClass> clazz = SampleClass.class;

            // 🛑 Thử truy cập một field KHÔNG tồn tại → phát sinh NoSuchFieldException
            Field field = clazz.getDeclaredField("nonExistingField");

            // ⚠️ Dòng dưới không chạy nếu lỗi xảy ra
            System.out.println("Field tìm thấy: " + field.getName());

        } catch (NoSuchFieldException e) {
            // 📌 Bắt lỗi khi field không tồn tại
            System.out.println("Lỗi NoSuchFieldException: Field không tồn tại trong class!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }
    }
}

// 📌 Class mẫu để demo
class SampleClassForField {
    private int existingField;
}
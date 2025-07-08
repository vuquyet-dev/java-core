package Exceptions.CheckedExceptions;

import java.lang.reflect.Method;

/**
 * 📝 NoSuchMethodException:
 * - Là một checked exception trong Java.
 * - Xảy ra khi sử dụng Reflection để truy cập một phương thức (method) mà **không tồn tại** trong class.
 * - Thường gặp khi:
 *     ⚠️ Gọi Class.getMethod("methodName", ...) hoặc Class.getDeclaredMethod(...)
 *         với tên method sai hoặc tham số không khớp.
 * - Là ngoại lệ quan trọng khi viết code động, plugin hoặc thư viện sử dụng reflection.
 */
public class NoSuchMethodExceptionExample {
    public static void main(String[] args) {
        try {
            // 🛑 Lấy class ví dụ
            Class<SampleClass> clazz = SampleClass.class;

            // 🛑 Thử truy cập một method KHÔNG tồn tại → phát sinh NoSuchMethodException
            Method method = clazz.getDeclaredMethod("nonExistingMethod");

            // ⚠️ Dòng dưới không chạy nếu lỗi xảy ra
            System.out.println("Method tìm thấy: " + method.getName());

        } catch (NoSuchMethodException e) {
            // 📌 Bắt lỗi khi method không tồn tại
            System.out.println("Lỗi NoSuchMethodException: Phương thức không tồn tại trong class!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }
    }
}

// 📌 Class mẫu để demo
class SampleClass {
    public void existingMethod() {
        // 📝 Method này tồn tại
    }
}

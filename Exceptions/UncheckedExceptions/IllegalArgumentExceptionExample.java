package Exceptions.UncheckedExceptions;

/**
 * 📝 IllegalArgumentException:
 * - Là một RuntimeException (unchecked exception) trong Java.
 * - Xảy ra khi một phương thức nhận được một đối số (argument) không hợp lệ
 *   hoặc không phù hợp với điều kiện mong đợi của phương thức.
 * - Rất thường gặp trong các API Java chuẩn (Collections, Math, …).
 */
public class IllegalArgumentExceptionExample {
    public static void main(String[] args) {
        try {
            // Gọi phương thức kiểm tra tuổi với giá trị âm
            checkAge(-5);

        } catch (IllegalArgumentException e) {
            // 📌 Bắt lỗi đối số không hợp lệ và in chi tiết
            System.out.println("Lỗi IllegalArgumentException!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc bình thường.");
    }

    /**
     * ⚙️ Phương thức kiểm tra tuổi:
     * - Tuổi phải lớn hơn hoặc bằng 0.
     * - Nếu tuổi nhỏ hơn 0, ném IllegalArgumentException.
     */
    static void checkAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Tuổi không được nhỏ hơn 0! Giá trị nhận được: " + age);
        }
        System.out.println("Tuổi hợp lệ: " + age);
    }
}

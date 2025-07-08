package Exceptions.UncheckedExceptions;

/**
 * 📝 RuntimeException:
 * - Là lớp cha của tất cả các unchecked exceptions trong Java (ArithmeticException, NullPointerException, v.v.).
 * - Có thể được ném ra trực tiếp nếu bạn muốn báo hiệu một lỗi logic xảy ra trong thời gian chạy.
 * - Không bắt buộc phải khai báo throws trong method.
 * - Nên hạn chế tự ném RuntimeException, chỉ khi thật sự cần phản ánh lỗi bất ngờ.
 */
public class RuntimeExceptionExample {
    public static void main(String[] args) {
        try {
            validateAge(-5); // ⚠️ Gửi tuổi không hợp lệ để cố tình gây lỗi

        } catch (RuntimeException e) {
            // 📌 Bắt bất kỳ RuntimeException nào được ném ra
            System.out.println("Đã bắt RuntimeException!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc bình thường.");
    }

    /**
     * 🛑 Phương thức kiểm tra tuổi. Nếu tuổi < 0, ném RuntimeException
     */
    public static void validateAge(int age) {
        if (age < 0) {
            throw new RuntimeException("Tuổi không thể nhỏ hơn 0!"); // Tự ném RuntimeException
        }

        System.out.println("Tuổi hợp lệ: " + age);
    }
}

package Exceptions.UncheckedExceptions;

import java.util.*;

/**
 * 📝 ConcurrentModificationException:
 * - Là một runtime exception (unchecked exception) trong Java.
 * - Xảy ra khi thay đổi (thêm/xóa) phần tử trong collection trong lúc đang duyệt bằng iterator/for-each.
 * - Nguyên nhân:
 *     ⚠️ Collection bị thay đổi trong khi đang lặp, iterator phát hiện bất nhất dữ liệu.
 * - Ví dụ thường gặp: Dùng for-each để lặp rồi xóa phần tử ngay trong vòng lặp.
 */
public class ConcurrentModificationExceptionExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        try {
            // 🛑 Duyệt bằng for-each rồi xóa trực tiếp → gây ConcurrentModificationException
            for (Integer num : numbers) {
                if (num % 2 == 0) {
                    numbers.remove(num); // ⚠️ Thao tác không an toàn!
                }
            }

            // ⚠️ Dòng dưới sẽ không chạy nếu lỗi xảy ra
            System.out.println("Kết thúc vòng lặp!");

        } catch (ConcurrentModificationException e) {
            // 📌 Bắt lỗi và in ra thông tin
            System.out.println("Lỗi ConcurrentModificationException: Không thể thay đổi collection trong lúc duyệt!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc bình thường.");
    }
}

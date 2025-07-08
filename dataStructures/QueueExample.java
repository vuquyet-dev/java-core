package dataStructures;

import java.util.*;

/**
 * ✅ Queue – Hàng đợi (FIFO: First In, First Out), được sử dụng để xử lý dữ liệu theo thứ tự nhập vào.
 *
 * 🔹 Đặc điểm:
 *   - Các phần tử được thêm vào cuối hàng đợi (tail) và lấy ra ở đầu hàng đợi (head).
 *   - Không cho phép chèn/xóa ở giữa.
 *   - Có thể triển khai bằng nhiều lớp: `LinkedList`, `PriorityQueue`, `ArrayDeque`, v.v.
 *
 * ✨ Ưu điểm:
 *   - ✅ Xử lý dữ liệu theo đúng thứ tự (phù hợp cho hệ thống hàng chờ, máy in, BFS, v.v.).
 *   - ✅ Hỗ trợ nhiều phương thức như `offer()`, `poll()`, `peek()` giúp xử lý linh hoạt.
 *
 * ⚠️ Nhược điểm:
 *   - ❌ Không linh hoạt như `List` (không truy cập theo index).
 *   - ❌ Với `LinkedList` thì tốc độ không nhanh bằng `ArrayDeque` cho một số thao tác.
 */

public class QueueExample {
    public static void main(String[] args) {
        try {
            // 1. Tạo Queue bằng LinkedList
            Queue<String> queue = new LinkedList<>();

            // 2. Thêm phần tử vào queue (.add() / .offer())
            System.out.println("\n1. Add elements to queue:");
            queue.add("Khách 1");
            queue.offer("Khách 2");
            queue.offer("Khách 3");
            queue.add("Khách 4");
            System.out.println("📥 Queue: " + queue);

            // 3. Xem phần tử đầu hàng mà không xoá (.element() / .peek())
            System.out.println("\n2. Peek first element:");
            System.out.println("🔍 .element(): " + queue.element()); // Throws exception if empty
            System.out.println("🔍 .peek(): " + queue.peek());       // Returns null if empty

            // 4. Lấy và xoá phần tử đầu hàng (.poll() / .remove())
            System.out.println("\n3. Remove elements from queue:");
            System.out.println("➡️ .poll(): " + queue.poll());       // Returns and removes
            System.out.println("➡️ .remove(): " + queue.remove());   // Throws exception if empty
            System.out.println("📥 After removal: " + queue);

            // 5. Kiểm tra phần tử có tồn tại không (.contains)
            System.out.println("\n4. Contains 'Khách 3'? " + queue.contains("Khách 3"));

            // 6. Kích thước hàng đợi (.size())
            System.out.println("\n5. Queue size: " + queue.size());

            // 7. Duyệt qua queue bằng for-each
            System.out.println("\n6. Browse queue:");
            for (String person : queue) {
                System.out.println("🔹 " + person);
            }

            // 8. Xoá toàn bộ queue (.clear)
            queue.clear();
            System.out.println("\n7. Cleared queue: " + queue);

            // 9. Kiểm tra rỗng (.isEmpty)
            System.out.println("\n8. Is queue empty? " + (queue.isEmpty() ? "✅ Yes" : "❌ No"));

        } catch (Exception ex) {
            System.out.println("❗ Error: " + ex.getMessage());
        }
    }
}

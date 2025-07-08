package DataStructures;

import java.util.*;

/**
 * ✅ Deque – Double-Ended Queue (hàng đợi 2 đầu), cho phép thêm và xóa phần tử ở cả đầu và cuối.
 *
 * 🔹 Đặc điểm:
 *   - Có thể hoạt động như Stack (LIFO) hoặc Queue (FIFO).
 *   - Được triển khai bởi `ArrayDeque` hoặc `LinkedList`.
 *   - Không cho phép phần tử null.
 *
 * ✨ Ưu điểm:
 *   - ✅ Linh hoạt: thêm/xóa ở cả hai đầu.
 *   - ✅ `ArrayDeque` nhanh hơn `Stack` và `LinkedList` trong hầu hết các trường hợp.
 *   - ✅ Hiệu suất tốt, không có chi phí đồng bộ (so với `Stack`).
 *
 * ⚠️ Nhược điểm:
 *   - ❌ Không thread-safe (nếu dùng đa luồng phải đồng bộ thủ công).
 *   - ❌ Không duyệt ngược mặc định.
 */

public class DequeExample {
    public static void main(String[] args) {
        try {
            // 1. Khởi tạo Deque bằng ArrayDeque
            Deque<String> deque = new ArrayDeque<>();

            // 2. Thêm phần tử vào đầu và cuối (.addFirst, .addLast)
            System.out.println("\n1. Add elements:");
            deque.addFirst("Trang A");  // Đầu
            deque.addLast("Trang B");   // Cuối
            deque.addFirst("Trang C");
            deque.addLast("Trang D");
            System.out.println("📘 Deque: " + deque);

            // 3. Peek đầu và cuối (.peekFirst, .peekLast)
            System.out.println("\n2. Peek first and last:");
            System.out.println("👀 First: " + deque.peekFirst());
            System.out.println("👀 Last: " + deque.peekLast());

            // 4. Pop đầu và cuối (.pollFirst, .pollLast)
            System.out.println("\n3. Poll elements:");
            System.out.println("🧹 Remove First: " + deque.pollFirst());
            System.out.println("🧹 Remove Last: " + deque.pollLast());
            System.out.println("📘 After removal: " + deque);

            // 5. Push như stack (.push), Pop (.pop)
            System.out.println("\n4. Push/Pop (stack-style):");
            deque.push("Trang E"); // push = addFirst
            System.out.println("📘 After push: " + deque);
            System.out.println("🧼 Pop: " + deque.pop()); // pop = removeFirst
            System.out.println("📘 After pop: " + deque);

            // 6. Kiểm tra phần tử (.contains)
            System.out.println("\n5. Contains 'Trang B'? " + deque.contains("Trang B"));

            // 7. Kích thước (.size)
            System.out.println("\n6. Size: " + deque.size());

            // 8. Duyệt deque
            System.out.println("\n7. Browse deque:");
            for (String page : deque) {
                System.out.println("📄 " + page);
            }

            // 9. Xoá toàn bộ (.clear)
            deque.clear();
            System.out.println("\n8. Cleared deque: " + deque);

            // 10. Kiểm tra rỗng (.isEmpty)
            System.out.println("\n9. Is deque empty? " + (deque.isEmpty() ? "✅ Yes" : "❌ No"));

        } catch (Exception ex) {
            System.out.println("❗ Error: " + ex.getMessage());
        }
    }
}

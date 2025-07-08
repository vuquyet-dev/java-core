package dataStructures;

import java.util.*;

/**
 * ✅ Stack – Cấu trúc dữ liệu dạng ngăn xếp (LIFO: Last In, First Out).
 *
 * 🔹 Đặc điểm:
 *   - Phần tử được thêm và lấy ra ở cùng một đầu (đỉnh stack).
 *   - Dùng cho các thao tác: quay lui (undo), duyệt cây, chuyển đổi biểu thức, kiểm tra dấu ngoặc,...
 *   - Được triển khai dựa trên `Vector`, kế thừa từ `List`.
 *
 * ✨ Ưu điểm:
 *   - ✅ Quản lý dữ liệu theo thứ tự LIFO dễ dàng.
 *   - ✅ Các thao tác cơ bản `push`, `pop`, `peek` có hiệu năng tốt (O(1)).
 *
 * ⚠️ Nhược điểm:
 *   - ❌ `Stack` là lớp cũ trong Java, ít được dùng hơn so với `Deque` (hiệu quả hơn).
 *   - ❌ Không hỗ trợ duyệt theo thứ tự đảo ngược sẵn.
 */

public class StackExample {
    public static void main(String[] args) {
        try {
            // 1. Tạo Stack
            Stack<String> stack = new Stack<>();

            // 2. Thêm phần tử vào stack (.push)
            System.out.println("\n1. Push elements:");
            stack.push("Trang 1");
            stack.push("Trang 2");
            stack.push("Trang 3");
            stack.push("Trang 4");
            System.out.println("📚 Stack: " + stack);

            // 3. Xem phần tử đầu stack nhưng không xoá (.peek)
            System.out.println("\n2. Peek top element:");
            System.out.println("👀 Top: " + stack.peek());

            // 4. Lấy và xoá phần tử đầu stack (.pop)
            System.out.println("\n3. Pop top element:");
            System.out.println("🧹 Removed: " + stack.pop());
            System.out.println("📚 After pop: " + stack);

            // 5. Tìm vị trí phần tử (.search)
            System.out.println("\n4. Search 'Trang 2' in stack:");
            int position = stack.search("Trang 2"); // Vị trí tính từ 1 (top = 1)
            System.out.println(position > 0 ? "🔎 Found at position: " + position : "❌ Not found");

            // 6. Kiểm tra rỗng (.empty)
            System.out.println("\n5. Is stack empty? " + (stack.empty() ? "✅ Yes" : "❌ No"));

            // 7. Duyệt stack bằng for-each (duyệt từ đáy lên)
            System.out.println("\n6. Browse stack (bottom to top):");
            for (String item : stack) {
                System.out.println("🔹 " + item);
            }

            // 8. Xoá toàn bộ (.clear bằng cách pop)
            System.out.println("\n7. Clearing stack:");
            while (!stack.isEmpty()) {
                System.out.println("❌ Removed: " + stack.pop());
            }

            // 9. Kiểm tra lại
            System.out.println("📦 Stack after clear: " + stack);

        } catch (Exception ex) {
            System.out.println("❗ Error: " + ex.getMessage());
        }
    }
}

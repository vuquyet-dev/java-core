package dataStructures;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * ✅ TreeSet là một lớp trong Java được sử dụng để lưu trữ các phần tử duy nhất (giống HashSet),
 * nhưng **có thứ tự tăng dần (sorted)** theo thứ tự tự nhiên hoặc comparator tùy chỉnh.
 *
 * 🔹 Đặc điểm chính:
 * - Không cho phép phần tử trùng lặp (giống HashSet).
 * - Các phần tử được **tự động sắp xếp** (tăng dần theo Comparable hoặc Comparator).
 * - Không cho phép phần tử null nếu so sánh được (sẽ gây lỗi NullPointerException).
 * - Dựa trên cấu trúc **cây đỏ-đen (Red-Black Tree)** nên hiệu năng các thao tác chính là O(log n).
 *
 * 🔧 Khi nên dùng TreeSet:
 * - Khi cần một tập hợp duy nhất nhưng **có sắp xếp tự động**.
 * - Khi cần thao tác như lấy phần tử nhỏ nhất/lớn nhất, tìm gần nhất (`ceiling`, `floor`, `higher`, `lower`).
 * - Khi cần loại bỏ trùng lặp và đồng thời muốn dữ liệu có thứ tự.

 * 📌 Nhược điểm:
 * - Chậm hơn `HashSet` vì phải duy trì thứ tự sắp xếp (O(log n) so với O(1) của HashSet).
 * - Không cho phép phần tử null nếu phải so sánh.
 *
 * ✨ TreeSet triển khai interface `NavigableSet`, kế thừa từ `SortedSet`, nên có nhiều phương thức nâng cao:
 * - `.first()`, `.last()`, `.ceiling(E)`, `.floor(E)`, `.subSet()`, `.headSet()`, `.tailSet()`, v.v.
 *
 * 📘 Ví dụ ứng dụng:
 * - Lưu danh sách điểm số tăng dần.
 * - Tìm phần tử gần nhất trong một dãy số.
 * - Lọc và sắp xếp dữ liệu tự động không trùng lặp.
 */

public class TreeSetClass {
    public static void main(String[] args) {
        try {
            // 1. Khởi tạo TreeSet
            TreeSet<String> productSet = new TreeSet<>();

            // 1. Thêm sản phẩm (.add)
            System.out.println("\n1. Add products:");
            productSet.add("Cà phê đen");
            productSet.add("Trà sữa");
            productSet.add("Bánh mì");
            productSet.add("Phở bò");
            productSet.add("Cơm tấm");
            productSet.add("Gỏi cuốn");
            System.out.println("➕ Products: " + productSet);

            // 2. Thêm phần tử trùng (bị bỏ qua)
            System.out.println("\n2. Add duplicate 'Phở bò':");
            boolean added = productSet.add("Phở bò");
            System.out.println(added ? "✅ Added" : "❌ Duplicate not added");
            System.out.println("📦 Current set: " + productSet);

            // 3. Xoá sản phẩm (.remove)
            System.out.println("\n3. Remove 'Cơm tấm':");
            productSet.remove("Cơm tấm");
            System.out.println("❌ After removal: " + productSet);

            // 4. Kiểm tra tồn tại (.contains)
            System.out.println("\n4. Contains 'Trà sữa'? " + productSet.contains("Trà sữa"));

            // 5. Duyệt bằng for-each
            System.out.println("\n5. Browse with for-each:");
            for (String item : productSet) {
                System.out.println("🔹 " + item);
            }

            // 6. Duyệt bằng Iterator
            System.out.println("\n6. Browse with Iterator:");
            Iterator<String> iterator = productSet.iterator();
            while (iterator.hasNext()) {
                System.out.println("➡️ " + iterator.next());
            }

            // 7. Lấy phần tử đầu và cuối (.first, .last)
            System.out.println("\n7. First and last product:");
            System.out.println("📍 First: " + productSet.first());
            System.out.println("📍 Last: " + productSet.last());

            // 8. Tìm phần tử lớn hơn hoặc bằng (.ceiling) và nhỏ hơn hoặc bằng (.floor)
            System.out.println("\n8. Ceiling & Floor of 'Gỏi':");
            System.out.println("🔼 Ceiling: " + productSet.ceiling("Gỏi"));//Trả về phần tử nhỏ nhất ≥ "Gỏi" trong TreeSet
            System.out.println("🔽 Floor: " + productSet.floor("Gỏi"));//Trả về phần tử lớn nhất ≤ "Gỏi" trong TreeSet

            // 9. Đếm số lượng sản phẩm (.size)
            System.out.println("\n9. Total products: " + productSet.size());

            // 10. Clone TreeSet (bằng constructor)
            TreeSet<String> cloneSet = new TreeSet<>(productSet);
            System.out.println("\n10. Clone set: " + cloneSet);

            // 11. Giữ lại phần tử chung (.retainAll)
            TreeSet<String> keepSet = new TreeSet<>(Arrays.asList("Trà sữa", "Phở bò"));
            productSet.retainAll(keepSet);
            System.out.println("\n11. After retainAll: " + productSet);

            // 12. Xoá tất cả phần tử cụ thể (.removeAll)
            productSet.removeAll(Collections.singleton("Phở bò"));
            System.out.println("\n12. After remove 'Phở bò': " + productSet);

            // 13. Xoá toàn bộ (.clear)
            productSet.clear();
            System.out.println("\n13. After clear: " + productSet);

            // 14. Kiểm tra rỗng (.isEmpty)
            System.out.println("\n14. Is set empty? " + (productSet.isEmpty() ? "✅ Yes" : "❌ No"));

        } catch (Exception ex) {
            System.out.println("❗ Error: " + ex.getMessage());
        }
    }
}

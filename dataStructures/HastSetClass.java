package dataStructures;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
/**
 * ✅ HashSet là một cấu trúc dữ liệu trong Java được dùng để lưu trữ tập hợp các phần tử duy nhất (không trùng lặp).
 *
 * 🔹 Đặc điểm chính:
 * - Không chứa phần tử trùng lặp (duplicates sẽ bị loại bỏ).
 * - Không đảm bảo thứ tự các phần tử khi duyệt (khác với List).
 * - Cho phép chứa phần tử null (duy nhất một phần tử null).
 * - Dựa trên bảng băm (hash table), nên thao tác thêm, xoá, kiểm tra tồn tại rất nhanh (trung bình O(1)).
 *
 * 🔧 Khi nên dùng HashSet:
 * - Khi cần lưu danh sách các giá trị duy nhất.
 * - Khi không quan tâm đến thứ tự chèn.
 * - Khi cần kiểm tra sự tồn tại nhanh chóng của phần tử.
 *
 * 📌 Nhược điểm:
 * - Không truy cập được phần tử theo chỉ số (index).
 * - Không giữ thứ tự chèn (nếu muốn giữ thứ tự, hãy dùng LinkedHashSet).
 *
 * ✨ HashSet triển khai interface Set nên hỗ trợ các phương thức như: add(), remove(), contains(), size(), isEmpty(), clear(), v.v.
 *
 * 📘 Ví dụ ứng dụng:
 * - Lọc danh sách tên bị trùng.
 * - Lưu các từ duy nhất trong một văn bản.
 * - Kiểm tra phần tử đã xuất hiện hay chưa.
 */

public class HastSetClass {
    public static void main(String[] args) {
        try {
            HashSet<String> foodSet = new HashSet<>();

            // 1. Thêm món ăn (.add)
            System.out.println("1️⃣ Add favorite foods:");
            foodSet.add("Cơm gà");
            foodSet.add("Phở bò");
            foodSet.add("Bún chả");
            foodSet.add("Chè bưởi");
            foodSet.add("Bánh mì");
            foodSet.add("Trà sữa");
            foodSet.add("Phở bò"); // Trùng, không thêm
            System.out.println("🍽️ Food list: " + foodSet);

            // 2. Kiểm tra số lượng (.size)
            System.out.println("\n2️⃣ Total items: " + foodSet.size());

            // 3. Kiểm tra món có tồn tại không (.contains)
            System.out.println("\n3️⃣ Contains 'Trà sữa'? " + (foodSet.contains("Trà sữa") ? "✅ Yes" : "❌ No"));

            // 4. Xóa món ăn cụ thể (.remove)
            foodSet.remove("Chè bưởi");
            System.out.println("\n4️⃣ After removing 'Chè bưởi': " + foodSet);

            // 5. Duyệt HashSet bằng for-each
            System.out.println("\n5️⃣ Duyệt bằng for-each:");
            for (String food : foodSet) {
                System.out.println("🔹 " + food);
            }

            // 6. Duyệt bằng Iterator
            System.out.println("\n6️⃣ Duyệt bằng Iterator:");
            Iterator<String> iterator = foodSet.iterator();
            while (iterator.hasNext()) {
                System.out.println("➡️ " + iterator.next());
            }

            // 7. Chuyển sang mảng (.toArray)
            System.out.println("\n7️⃣ Convert to array:");
            Object[] foodArray = foodSet.toArray();
            for (Object item : foodArray) {
                System.out.println("🍜 " + item);
            }

            // 8. Clone HashSet (.clone)
            HashSet<String> clonedSet = (HashSet<String>) foodSet.clone();
            System.out.println("\n8️⃣ Cloned set: " + clonedSet);

            // 9. So sánh 2 set (.equals)
            System.out.println("\n9️⃣ Equals to cloned set? " + (foodSet.equals(clonedSet) ? "✅ Equal" : "❌ Not equal"));

            // 10. Gộp set mới (.addAll)
            HashSet<String> moreFoods = new HashSet<>();
            moreFoods.add("Gỏi cuốn");
            moreFoods.add("Bánh xèo");
            foodSet.addAll(moreFoods);
            System.out.println("\n🔟 After merging more foods: " + foodSet);

            // 11. Giữ lại món chung (.retainAll)
            HashSet<String> keepList = new HashSet<>(Arrays.asList("Phở bò", "Bánh mì", "Gỏi cuốn"));
            foodSet.retainAll(keepList);
            System.out.println("\n1️⃣1️⃣ After retaining common foods: " + foodSet);

            // 12. Xóa theo nhóm (.removeAll)
                foodSet.removeAll(Collections.singleton("Phở bò"));
            System.out.println("\n1️⃣2️⃣ After removing 'Phở bò': " + foodSet);
            foodSet.remove("Phở bò");

            // 13. Xóa toàn bộ (.clear)
            foodSet.clear();
            System.out.println("\n1️⃣3️⃣ After clearing set: " + foodSet);

            // 14. Kiểm tra rỗng (.isEmpty)
            System.out.println("\n1️⃣4️⃣ Is set empty? " + (foodSet.isEmpty() ? "✅ Yes" : "❌ No"));

        } catch (Exception ex) {
            System.out.println("❗ Error: " + ex.getMessage());
        }
    }
}

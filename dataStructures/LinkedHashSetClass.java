package dataStructures;

import java.util.*;
/**
 * ✅ LinkedHashSet – Lớp tập hợp không cho phép phần tử trùng lặp và **duy trì thứ tự chèn**.
 * 🔹 Các đặc điểm chính:
 *   - Không chứa phần tử trùng.
 *   - Duy trì **thứ tự thêm vào** (khác với HashSet).
 *   - Duyệt nhanh và ổn định hơn HashSet nếu cần giữ thứ tự.
 *   - Không cho phép truy cập bằng chỉ số (index).
 */
public class LinkedHashSetClass {
    public static void main(String[] args) {
        try {
            // 1. Khởi tạo LinkedHashSet
            LinkedHashSet<String> productSet = new LinkedHashSet<>();

            // 1. Thêm sản phẩm (.add)
            System.out.println("\n1. Add products:");
            productSet.add("Trà đào");
            productSet.add("Cà phê sữa");
            productSet.add("Phở gà");
            productSet.add("Cơm chiên");
            productSet.add("Bún bò Huế");
            System.out.println("➕ Products: " + productSet);

            // 2. Thêm phần tử trùng
            System.out.println("\n2. Add duplicate 'Trà đào':");
            boolean added = productSet.add("Trà đào");
            System.out.println(added ? "✅ Added" : "❌ Duplicate not added");
            System.out.println("📦 Current set: " + productSet);

            // 3. Xoá sản phẩm (.remove)
            System.out.println("\n3. Remove 'Phở gà':");
            productSet.remove("Phở gà");
            System.out.println("❌ After removal: " + productSet);

            // 4. Kiểm tra tồn tại (.contains)
            System.out.println("\n4. Contains 'Cơm chiên'? " + productSet.contains("Cơm chiên"));

            // 5. Duyệt bằng for-each
            System.out.println("\n5. Browse with for-each:");
            for (String product : productSet) {
                System.out.println("🔸 " + product);
            }

            // 6. Duyệt bằng Iterator
            System.out.println("\n6. Browse with Iterator:");
            Iterator<String> iterator = productSet.iterator();
            while (iterator.hasNext()) {
                System.out.println("➡️ " + iterator.next());
            }

            // 7. Đếm số phần tử (.size)
            System.out.println("\n7. Total products: " + productSet.size());

            // 8. Clone LinkedHashSet
            LinkedHashSet<String> cloneSet = new LinkedHashSet<>(productSet);
            System.out.println("\n8. Clone set: " + cloneSet);

            // 9. Giữ lại phần tử chung (.retainAll)
            LinkedHashSet<String> keepSet = new LinkedHashSet<>(Arrays.asList("Cà phê sữa", "Trà đào"));
            productSet.retainAll(keepSet);
            System.out.println("\n9. After retainAll: " + productSet);

            // 10. Xoá tất cả phần tử cụ thể (.removeAll)
            productSet.removeAll(Collections.singleton("Cà phê sữa"));
            System.out.println("\n10. After removing 'Cà phê sữa': " + productSet);

            // 11. Xoá toàn bộ (.clear)
            productSet.clear();
            System.out.println("\n11. After clear: " + productSet);

            // 12. Kiểm tra rỗng (.isEmpty)
            System.out.println("\n12. Is set empty? " + (productSet.isEmpty() ? "✅ Yes" : "❌ No"));

        } catch (Exception ex) {
            System.out.println("❗ Error: " + ex.getMessage());
        }
    }
}

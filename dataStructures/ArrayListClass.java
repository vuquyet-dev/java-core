package dataStructures;

import java.util.*;
/**
 * ✅ ArrayList là một lớp trong Java đại diện cho danh sách (List) động, nằm trong gói java.util.
 *
 * 🔹 Đặc điểm chính:
 * - Dữ liệu được lưu trữ theo chỉ số, tương tự mảng.
 * - Cho phép phần tử trùng lặp và duy trì thứ tự chèn (insertion order).
 * - Tự động thay đổi kích thước khi thêm/xoá phần tử.
 * - Hỗ trợ truy cập ngẫu nhiên nhanh qua chỉ số (O(1)).
 *
 * 🔧 Khi nên dùng ArrayList:
 * - Khi cần truy cập nhanh theo chỉ số (get/set).
 * - Khi số lần thêm/xoá không quá nhiều hoặc chủ yếu là ở cuối danh sách.
 * - Khi cần lưu trữ danh sách có trật tự cụ thể (ví dụ: danh sách sản phẩm, danh sách sinh viên).
 *
 * 📌 Nhược điểm:
 * - Thêm/xoá ở đầu hoặc giữa danh sách có thể chậm vì phải dời các phần tử (O(n)).
 * - Không đồng bộ (nếu dùng đa luồng cần dùng Collections.synchronizedList hoặc CopyOnWriteArrayList).
 *
 * ✨ Ghi chú:
 * - ArrayList triển khai interface List nên có thể dùng đa hình với List<String>, List<Integer>, v.v.
 * - ArrayList không giới hạn kích thước cụ thể (nhưng phụ thuộc vào bộ nhớ hệ thống).
 */

public class ArrayListClass {
    public static void main(String[] args) {
        try {
            ArrayList<String> productList = new ArrayList<>();

            // 1. Add products (.add())
            System.out.println("\n1. Add products");
            productList.add("Cà phê sữa");
            productList.add("Trà đào");
            productList.add("Bánh mì thịt");
            productList.add("Cơm tấm");
            productList.add("Phở bò");
            productList.add("Trà sữa trân châu");
            productList.add("Bún chả");
            productList.add("Pizza hải sản");
            System.out.println("➕ Added products: " + productList);
            // 2. Get product at specific index (.get())
            System.out.println("\n2. Get product at index 3:");
            System.out.println("📦 " + productList.get(3)); // Cơm tấm

            // 3. Edit product name (.set(index, value))
            System.out.println("\n3. Edit product at index 2:");
            productList.set(2, "Bánh mì chay");
            System.out.println("📝 Updated list: " + productList);

            // 4. Delete by index or by name (.remove())
            System.out.println("\n4. Delete by index and name:");
            productList.remove(4); // Remove Phở bò
            productList.remove("Bún chả");
            System.out.println("❌ After deletion: " + productList);

            // 5. Search for product index (.indexOf(), .lastIndexOf())
            System.out.println("\n5. Search for index of 'Trà đào':");
            productList.add("Trà đào"); // Thêm lại để kiểm tra lastIndexOf
            System.out.println("First index: " + productList.indexOf("Trà đào"));
            System.out.println("Last index: " + productList.lastIndexOf("Trà đào"));

            // 6. Check for existence (.contains())
            System.out.println("\n6. Contains 'Pizza hải sản'? " + productList.contains("Pizza hải sản"));

            // 7. Browse with for-each, for, iterator
            System.out.println("\n7. Browse with for-each:");
            for (String product : productList) {
                System.out.println("🔸 " + product);
            }

            System.out.println("\nBrowse with classic for:");
            for (int i = 0; i < productList.size(); i++) {
                System.out.println("🔹 " + productList.get(i));
            }

            System.out.println("\nBrowse with iterator:");
            Iterator<String> iterator = productList.iterator();
            while (iterator.hasNext()) {
                System.out.println("➡️ " + iterator.next());
            }

            // 8. Count total products (.size())
            System.out.println("\n8. Total products: " + productList.size());

            // 9. Sort A-Z (Collections.sort())
            Collections.sort(productList);
            System.out.println("\n9. Sorted list (A-Z): " + productList);

            // 10. Clone list (.clone())
            ArrayList<String> cloneList = (ArrayList<String>) productList.clone();
            System.out.println("\n10. Clone of list: " + cloneList);

            // 11. Merge with another list (.addAll())
            ArrayList<String> newList = new ArrayList<>();
            newList.add("Cháo gà");
            newList.add("Mì xào bò");
            productList.addAll(newList);
            System.out.println("\n11. After merging new list: " + productList);

            // 12. Keep common elements (.retainAll())
            ArrayList<String> keepList = new ArrayList<>(Arrays.asList("Trà đào", "Pizza hải sản", "Cháo gà"));
            productList.retainAll(keepList);
            System.out.println("\n12. After retaining common items: " + productList);

            // 13. Remove specific values (.removeAll())
            productList.removeAll(Collections.singleton("Trà đào"));
            System.out.println("\n13. After removing 'Trà đào': " + productList);

            // 14. Convert to array (.toArray())
            System.out.println("\n14. Convert to array:");
            Object[] array = productList.toArray();
            for (Object obj : array) {
                System.out.println("🔹 " + obj);
            }

            // 15. Compare 2 lists (.equals())
            System.out.println("\n15. Compare with clone list:");
            System.out.println(productList.equals(cloneList) ? "✅ Equal" : "❌ Not equal");

            // 16. Clear list (.clear())
            productList.clear();
            System.out.println("\n16. Cleared list: " + productList);

            // 17. Check if empty (.isEmpty())
            System.out.println("\n17. Is list empty? " + (productList.isEmpty() ? "✅ Yes" : "❌ No"));

        } catch (Exception ex) {
            System.out.println("❗ Error: " + ex.getMessage());
        }
    }
}

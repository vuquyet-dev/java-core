package dataStructures;

import java.util.*;

/**
 * ✅ LinkedHashMap – Là một dạng Map lưu các cặp key-value **duy trì thứ tự thêm vào (insertion order)**.
 *
 * 🔹 Đặc điểm:
 *   - Duy trì thứ tự các phần tử theo đúng thứ tự bạn đã thêm.
 *   - Cho phép 1 key duy nhất, value có thể trùng lặp.
 *   - Cho phép `null` cho cả key và value.
 *   - Dựa trên bảng băm (hash table) + danh sách liên kết đôi (doubly linked list).
 *
 * ✨ Ưu điểm:
 *   - ✅ Duy trì thứ tự thêm vào → phù hợp để hiển thị dữ liệu chính xác theo trình tự người dùng nhập.
 *   - ✅ Truy xuất nhanh với độ phức tạp trung bình O(1) cho các thao tác `put`, `get`, `remove`.
 *   - ✅ Hữu ích khi bạn cần vừa **hiệu suất cao** vừa **giữ thứ tự ổn định**.
 *
 * ⚠️ Nhược điểm:
 *   - ❌ Tốn nhiều bộ nhớ hơn `HashMap` do lưu thêm liên kết.
 *   - ❌ Không tự động sắp xếp như `TreeMap`.
 */

public class LinkedHashMapClass {
    public static void main(String[] args) {
        try {
            // 1. Tạo và thêm dữ liệu
            LinkedHashMap<String, String> drinkMap = new LinkedHashMap<>();
            drinkMap.put("D01", "Trà sữa");
            drinkMap.put("D02", "Cà phê");
            drinkMap.put("D03", "Nước cam");
            drinkMap.put("D04", "Sữa tươi");
            drinkMap.put("D05", "Trà chanh");

            System.out.println("\n1. Initial drink list:");
            System.out.println("📋 " + drinkMap);

            // 2. Truy cập phần tử qua key
            System.out.println("\n2. Get 'D03': " + drinkMap.get("D03"));

            // 3. Kiểm tra tồn tại key hoặc value
            System.out.println("\n3. Contains key 'D01'? " + drinkMap.containsKey("D01"));
            System.out.println("Contains value 'Cà phê'? " + drinkMap.containsValue("Cà phê"));

            // 4. Cập nhật giá trị (put)
            System.out.println("\n4. Update 'D02' to 'Cà phê đen':");
            drinkMap.put("D02", "Cà phê đen");
            System.out.println("📝 Updated map: " + drinkMap);

            // 5. Xoá phần tử (remove)
            System.out.println("\n5. Remove 'D05':");
            drinkMap.remove("D05");
            System.out.println("❌ After removal: " + drinkMap);

            // 6. Duyệt bằng for-each
            System.out.println("\n6. Browse with for-each:");
            for (Map.Entry<String, String> entry : drinkMap.entrySet()) {
                System.out.println("🔹 " + entry.getKey() + ": " + entry.getValue());
            }

            // 7. Clone LinkedHashMap
            LinkedHashMap<String, String> cloneMap = new LinkedHashMap<>(drinkMap);
            System.out.println("\n7. Cloned map: " + cloneMap);

            // 8. Xoá toàn bộ (.clear)
            drinkMap.clear();
            System.out.println("\n8. After clearing: " + drinkMap);

            // 9. Kiểm tra rỗng
            System.out.println("\n9. Is map empty? " + (drinkMap.isEmpty() ? "✅ Yes" : "❌ No"));

        } catch (Exception ex) {
            System.out.println("❗ Error: " + ex.getMessage());
        }
    }
}

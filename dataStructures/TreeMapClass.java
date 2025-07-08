package dataStructures;

import java.util.*;

/**
 * ✅ TreeMap – Cấu trúc Map lưu các cặp key-value và **tự động sắp xếp key theo thứ tự tăng dần**.
 *
 * 🔹 Đặc điểm:
 *   - Lưu trữ dữ liệu dưới dạng cặp `key-value`.
 *   - Các key được sắp xếp theo thứ tự tự nhiên (hoặc theo Comparator tùy chọn).
 *   - Duyệt các phần tử theo thứ tự của key.
 *   - Không cho phép key là null, nhưng value có thể là null.
 *
 * ✨ Ưu điểm:
 *   - Tự động **duy trì thứ tự key tăng dần**, thuận tiện khi cần dữ liệu có tổ chức.
 *   - Hỗ trợ nhanh các thao tác như tìm phần tử nhỏ nhất/lớn nhất (`firstKey()`, `lastKey()`).
 *   - Phù hợp với các bài toán tìm kiếm nhị phân hoặc cây cân bằng (ví dụ: từ điển, bảng mã).
 *
 * ⚠️ Nhược điểm:
 *   - Tốc độ chậm hơn `HashMap` do phải duy trì thứ tự sắp xếp (O(log n)).
 *   - Không cho phép key là null (nếu dùng sẽ gây lỗi NullPointerException).
 *   - Dung lượng bộ nhớ cao hơn trong trường hợp dữ liệu lớn so với `HashMap`.
 */

public class TreeMapClass {
    public static void main(String[] args) {
        try {
            // 1. Khởi tạo TreeMap
            TreeMap<String, String> menuMap = new TreeMap<>();

            // 1. Thêm dữ liệu (.put)
            System.out.println("\n1. Add items:");
            menuMap.put("B01", "Phở bò");
            menuMap.put("C02", "Cơm tấm");
            menuMap.put("T03", "Trà đào");
            menuMap.put("B02", "Bún chả");
            menuMap.put("C01", "Cháo gà");
            System.out.println("📦 Menu: " + menuMap);

            // 2. Truy cập theo key (.get)
            System.out.println("\n2. Get item with key 'C02':");
            System.out.println("🔹 " + menuMap.get("C02"));

            // 3. Kiểm tra tồn tại key/value
            System.out.println("\n3. Contains key 'T03'? " + menuMap.containsKey("T03"));
            System.out.println("Contains value 'Bún chả'? " + menuMap.containsValue("Bún chả"));

            // 4. Cập nhật value (.put)
            System.out.println("\n4. Update item with key 'B02':");
            menuMap.put("B02", "Bún bò Huế");
            System.out.println("📝 Updated menu: " + menuMap);

            // 5. Xoá phần tử (.remove)
            System.out.println("\n5. Remove item with key 'C01':");
            menuMap.remove("C01");
            System.out.println("❌ After removal: " + menuMap);

            // 6. Duyệt bằng for-each
            System.out.println("\n6. Browse with for-each:");
            for (Map.Entry<String, String> entry : menuMap.entrySet()) {
                System.out.println("🔸 Code: " + entry.getKey() + ", Name: " + entry.getValue());
            }

            // 7. Duyệt bằng iterator
            System.out.println("\n7. Browse with iterator:");
            Iterator<Map.Entry<String, String>> iterator = menuMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                System.out.println("➡️ " + entry.getKey() + ": " + entry.getValue());
            }

            // 8. Lấy key đầu và cuối (.firstKey, .lastKey)
            System.out.println("\n8. First key: " + menuMap.firstKey());
            System.out.println("Last key: " + menuMap.lastKey());

            // 9. Clone TreeMap
            TreeMap<String, String> cloneMap = new TreeMap<>(menuMap);
            System.out.println("\n9. Clone map: " + cloneMap);

            // 10. Xoá toàn bộ (.clear)
            menuMap.clear();
            System.out.println("\n10. Cleared map: " + menuMap);

            // 11. Kiểm tra rỗng (.isEmpty)
            System.out.println("\n11. Is map empty? " + (menuMap.isEmpty() ? "✅ Yes" : "❌ No"));

        } catch (Exception ex) {
            System.out.println("❗ Error: " + ex.getMessage());
        }
    }
}

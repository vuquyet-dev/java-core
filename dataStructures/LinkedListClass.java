package dataStructures;

import java.util.*;
/**
 * ✅ LinkedList là một cấu trúc dữ liệu tuyến tính trong Java, hoạt động theo dạng danh sách liên kết đôi (doubly linked list).
 *
 * 🔹 Đặc điểm chính:
 * - Cho phép thêm/xoá phần tử nhanh ở đầu hoặc cuối danh sách (O(1)).
 * - Không giữ thứ tự cố định trong bộ nhớ như ArrayList.
 * - Không giới hạn kích thước (tự động co giãn).
 * - Cho phép phần tử trùng lặp.
 * - Hỗ trợ tất cả các phương thức của List và Queue.
 *
 * 🔧 Khi nên dùng LinkedList:
 * - Khi cần thao tác chèn/xoá nhiều ở đầu/cuối danh sách.
 * - Khi không cần truy cập ngẫu nhiên thường xuyên (vì .get(index) chậm hơn ArrayList).
 *
 * 📌 Nhược điểm:
 * - Truy cập theo chỉ số chậm hơn ArrayList do phải duyệt từng node.
 */

public class LinkedListClass {
    public static void main(String[] args) {
        try {
            LinkedList<String> foodList = new LinkedList<>();

            // 1. Thêm món ăn vào cuối danh sách (.add)
            System.out.println("1️⃣ Add foods:");
            foodList.add("Bánh mì");
            foodList.add("Cơm gà");
            foodList.add("Phở bò");
            foodList.add("Trà sữa");
            System.out.println("🍽️ Food list: " + foodList);

            // 2. Thêm món vào đầu và cuối (.addFirst, .addLast)
            foodList.addFirst("Cháo lòng");
            foodList.addLast("Bún đậu mắm tôm");
            System.out.println("\n2️⃣ After addFirst & addLast: " + foodList);

            // 3. Lấy món đầu và cuối (.getFirst, .getLast)
            System.out.println("\n3️⃣ First food: " + foodList.getFirst());
            System.out.println("Last food: " + foodList.getLast());

            // 4. Lấy món ở vị trí bất kỳ (.get)
            System.out.println("\n4️⃣ Food at index 3: " + foodList.get(3));

            // 5. Thay đổi món ăn (.set)
            foodList.set(2, "Bánh cuốn");
            System.out.println("\n5️⃣ After update index 2: " + foodList);

            // 6. Xoá món ăn đầu/cuối (.removeFirst, .removeLast)
            foodList.removeFirst();
            foodList.removeLast();
            System.out.println("\n6️⃣ After removeFirst & removeLast: " + foodList);

            // 7. Xoá món bất kỳ theo chỉ số hoặc tên (.remove, .remove(index))
            foodList.remove("Trà sữa");
            foodList.remove(1); // xoá theo index
            System.out.println("\n7️⃣ After removing by name & index: " + foodList);

            // 8. Duyệt danh sách với for-each
            System.out.println("\n8️⃣ Browse with for-each:");
            for (String food : foodList) {
                System.out.println("🔹 " + food);
            }

            // 9. Duyệt bằng Iterator
            System.out.println("\n9️⃣ Browse with Iterator:");
            Iterator<String> it = foodList.iterator();
            while (it.hasNext()) {
                System.out.println("➡️ " + it.next());
            }

            // 10. Kiểm tra tồn tại món (.contains)
            System.out.println("\n🔟 Contains 'Phở bò'? " + foodList.contains("Phở bò"));

            // 11. Tìm vị trí đầu và cuối của món (.indexOf, .lastIndexOf)
            foodList.add("Bánh cuốn");
            System.out.println("\n1️⃣1️⃣ First index of 'Bánh cuốn': " + foodList.indexOf("Bánh cuốn"));
            System.out.println("Last index of 'Bánh cuốn': " + foodList.lastIndexOf("Bánh cuốn"));

            // 12. Đếm số lượng món (.size)
            System.out.println("\n1️⃣2️⃣ Total foods: " + foodList.size());

            // 13. Sắp xếp A-Z (Collections.sort)
            Collections.sort(foodList);
            System.out.println("\n1️⃣3️⃣ Sorted foods: " + foodList);

            // 14. Chuyển sang mảng (.toArray)
            System.out.println("\n1️⃣4️⃣ Convert to array:");
            Object[] arr = foodList.toArray();
            for (Object o : arr) {
                System.out.println("🍜 " + o);
            }

            // 15. Sao chép danh sách (.clone)
            LinkedList<String> cloneList = (LinkedList<String>) foodList.clone();
            System.out.println("\n1️⃣5️⃣ Cloned list: " + cloneList);

            // 16. So sánh hai danh sách (.equals)
            System.out.println("\n1️⃣6️⃣ Is equal to cloned list? " + (foodList.equals(cloneList) ? "✅ Equal" : "❌ Not equal"));

            // 17. Xoá tất cả món (.clear) và kiểm tra rỗng (.isEmpty)
            foodList.clear();
            System.out.println("\n1️⃣7️⃣ Cleared list: " + foodList);
            System.out.println("Is list empty? " + (foodList.isEmpty() ? "✅ Yes" : "❌ No"));

        } catch (Exception ex) {
            System.out.println("❗ Error: " + ex.getMessage());
        }
    }
}

package dataStructures;
import java.util.*;
/**
 * ✅ HashMap là một cấu trúc dữ liệu ánh xạ (map) trong Java dùng để lưu trữ các cặp key-value.
 *
 * 🔹 Đặc điểm chính:
 * - Không cho phép key trùng lặp (mỗi key là duy nhất).
 * - Value có thể trùng lặp.
 * - Dựa trên bảng băm (hash table), nên thao tác thêm/xoá/tìm kiếm rất nhanh (trung bình O(1)).
 * - Không đảm bảo thứ tự các phần tử khi duyệt.
 * - Cho phép 1 key là `null` và nhiều value là `null`.
 *
 * 🔧 Khi nên dùng HashMap:
 * - Khi cần tra cứu nhanh theo key.
 * - Khi không quan tâm đến thứ tự lưu trữ.
 * - Khi cần lưu trữ dữ liệu dạng cặp: ví dụ (mã sinh viên - tên), (id sản phẩm - giá), v.v.
 *
 * 📌 Nhược điểm:
 * - Không đồng bộ (nếu dùng trong môi trường đa luồng cần dùng `Collections.synchronizedMap()` hoặc `ConcurrentHashMap`).
 * - Duyệt các phần tử không theo thứ tự chèn.
 *
 * ✨ Lưu ý: HashMap triển khai interface `Map<K, V>`, không kế thừa từ `Collection`.
 */

public class HashMapClass {
    public static void main(String[] args) {
        try{
            java.util.HashMap<String, Double> studentList = new java.util.HashMap<>();

            //Enter student list (.put())
            studentList.put("Quyet", 8.0);
            studentList.put("Trinh", 9.5);
            studentList.put("Phuc", 7.8);
            studentList.put("Thinh", 8.8);
            studentList.put("Phuong", 6.0);

            System.out.println("1. Created 5 students");

            //Print student list (.entrySet())
            System.out.println("\n2. Print student list: ");
            System.out.println(studentList.entrySet());

            //Find and print the score of any student (by name) (.get(), .containsKey())
            //Cannot duplicate key
            System.out.print("\n3. Find and print the score of any student(Quyet): ");
            String name = "Quyet";
            if(studentList.containsKey(name))
            {
                System.out.println(studentList.get(name));
            }

            //Update any student's score (.put())
            System.out.print("\n4. Update any student's score(Quyet): ");
            studentList.put("Quyet", 9.0);
            System.out.println(studentList.get("Quyet"));
            System.out.println(studentList.entrySet());

            //Delete any element of the list (.remove())
            System.out.println("\n5. Delete any element of the list(Thinh): ");
            studentList.remove("Thinh");
            System.out.println(studentList.entrySet());

            //Check if a score exists (.containsValue())
            System.out.println("\n6. Check if a score exists(9.0): ");
            if(studentList.containsValue(9.0))
            {
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }

            //Print all students name (.keySet())
            System.out.println("\n 7.Print all students name: ");
            System.out.println(studentList.keySet());

            //Print all students score (.values())
            System.out.println("\n 8.Print all students score: ");
            System.out.println(studentList.values());

            //Delete all list (.clear())
            System.out.println("\n 9. Clear all list: ");
            studentList.clear();
            System.out.println(studentList.entrySet());

            //Check if list is empty (.isEmpty())
            System.out.println("\n 10. Check if list is empty");
            if(studentList.isEmpty())
            {
                System.out.println("The list is empty");
            }else {
                System.out.println("The list is not empty");
            }
        }catch (NoSuchElementException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}


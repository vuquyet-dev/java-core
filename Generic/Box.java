package Generic; // Gói tên là Generic

import java.util.ArrayList; // Import lớp ArrayList để chứa danh sách các phần tử

// ✅ Lớp Box là lớp generic với kiểu T (giới hạn T phải là lớp con của Item)
// ✅ Box cũng implements interface Storage<T> (đảm bảo có các phương thức add và getById)
public class Box<T extends Item> implements Storage<T> {

    // Khai báo một danh sách (ArrayList) để lưu trữ các đối tượng kiểu T
    private ArrayList<T> items = new ArrayList<>();

    // ✅ Ghi đè phương thức add từ interface Storage<T>
    @Override
    public void add(T item) {
        items.add(item); // Thêm phần tử vào danh sách
    }

    // ✅ Ghi đè phương thức getById từ interface Storage<T>
    @Override
    public T getById(int id) {
        for (T item : items) { // Duyệt qua tất cả phần tử trong danh sách
            if (item.getId() == id) return item; // Nếu tìm thấy item có id khớp thì trả về
        }
        return null; // Không tìm thấy thì trả về null
    }

    // ✅ Phương thức riêng để in toàn bộ các phần tử trong hộp
    public void printAll() {
        for (T item : items) {
            System.out.println(item); // Gọi toString() của item để in ra
        }
    }
}

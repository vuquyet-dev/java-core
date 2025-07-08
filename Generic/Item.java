package Generic; // Gói chứa class này là 'Generic'

// ✅ Lớp Item biểu diễn một đối tượng có id và tên
public class Item {
    // 🔹 Thuộc tính riêng (private): id và name
    private int id;
    private String name;

    // ✅ Constructor khởi tạo Item với id và name
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // ✅ Getter cho id (cho phép truy xuất id từ bên ngoài)
    public int getId() {
        return id;
    }

    // ✅ Getter cho name (cho phép truy xuất name từ bên ngoài)
    public String getName() {
        return name;
    }

    // ✅ Ghi đè phương thức toString để in thông tin đối tượng theo định dạng dễ đọc
    @Override
    public String toString() {
        return "Item{id=" + id + ", name='" + name + "'}";
    }
}

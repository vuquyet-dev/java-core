package Generic; // Gói chứa interface này là 'Generic'

// ✅ Khai báo một interface generic tên là Storage, có tham số kiểu T
public interface Storage<T> {

    // 🔹 Phương thức trừu tượng để thêm một đối tượng kiểu T vào nơi lưu trữ
    void add(T item);

    // 🔹 Phương thức trừu tượng để tìm một đối tượng theo id (giả định id là int)
    T getById(int id);
}

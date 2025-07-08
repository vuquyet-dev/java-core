package Generic; // Khai báo package tên là Generic

import java.util.ArrayList; // Import lớp ArrayList để dùng danh sách động

public class Main { // Lớp chính chứa hàm main và các phương thức generic

    public static void main(String[] args) {
        // Tạo một hộp chứa các đối tượng Item (Box là class generic)
        Box<Item> itemBox = new Box<>();

        // Thêm 3 item vào hộp
        itemBox.add(new Item(1, "Book"));
        itemBox.add(new Item(2, "Laptop"));
        itemBox.add(new Item(3, "Pen"));

        // In tất cả các item trong hộp ra màn hình
        itemBox.printAll();

        // Tạo một danh sách mới để test phương thức findById()
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(new Item(10, "Mouse"));
        itemList.add(new Item(11, "Keyboard"));

        // Gọi phương thức generic findById để tìm item có id = 11
        System.out.println("Find ID 11: " + findById(itemList, 11));

        // Tạo một mảng số nguyên để test phương thức findMax()
        Integer[] numbers = {10, 22, 5, 66, 33};

        // Gọi phương thức generic findMax để tìm phần tử lớn nhất
        System.out.println("Max: " + findMax(numbers));
    }

    // ✅ Phương thức generic để tìm một phần tử trong danh sách dựa theo ID
    // T extends Item: giới hạn kiểu T phải là lớp con của Item (để dùng getId)
    public static <T extends Item> T findById(ArrayList<T> list, int id) {
        for (T item : list) {
            if (item.getId() == id) return item; // So sánh ID
        }
        return null; // Không tìm thấy thì trả về null
    }

    // ✅ Phương thức generic có giới hạn để tìm phần tử lớn nhất trong mảng
    // T extends Comparable<T>: đảm bảo các phần tử có thể so sánh được bằng compareTo
    public static <T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0]; // Giả sử phần tử đầu là lớn nhất
        for (T item : array) {
            if (item.compareTo(max) > 0) max = item; // Nếu item lớn hơn max thì cập nhật max
        }
        return max; // Trả về phần tử lớn nhất
    }
}

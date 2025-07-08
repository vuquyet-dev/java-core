package Exceptions.UncheckedExceptions;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/**
 * 📝 IllegalStateException:
 * - Là một runtime exception (unchecked exception) trong Java.
 * - Xảy ra khi gọi một phương thức ở **trạng thái không hợp lệ** của đối tượng.
 * - Thường gặp khi:
 *     ⚠️ Sử dụng Iterator.remove() mà không gọi next() trước.
 *     ⚠️ Gọi phương thức trên đối tượng đang ở trạng thái sai lệch (ví dụ Scanner đóng rồi vẫn next()).
 */
public class IllegalStateExceptionExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        Iterator<String> iterator = list.iterator();

        try {
            // 🛑 Gọi remove() ngay lập tức trước khi next() → phát sinh IllegalStateException
            iterator.remove();

            // ⚠️ Dòng dưới sẽ không chạy nếu lỗi xảy ra
            System.out.println("Đã xóa phần tử.");

        } catch (IllegalStateException e) {
            // 📌 Bắt lỗi khi gọi phương thức ở trạng thái không hợp lệ
            System.out.println("Lỗi IllegalStateException: Gọi remove() trước next() không hợp lệ!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc bình thường.");
    }
}

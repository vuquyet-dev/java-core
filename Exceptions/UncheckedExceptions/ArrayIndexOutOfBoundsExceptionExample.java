package Exceptions.UncheckedExceptions;

/**
 * 📝 ArrayIndexOutOfBoundsException:
 * - Là một runtime exception (unchecked exception) trong Java.
 * - Xảy ra khi cố gắng truy cập phần tử có chỉ số (index) nằm ngoài phạm vi mảng.
 *     ⚠️ Ví dụ: Mảng có 5 phần tử nhưng truy cập phần tử ở vị trí index 10.
 * - Java kiểm tra chỉ số mảng ở runtime, nếu vượt quá phạm vi sẽ ném ngoại lệ này ngay lập tức.
 */
public class ArrayIndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50}; // 📌 Mảng có 5 phần tử, chỉ số từ 0 -> 4

        try {
            int index = 10; // ⚠️ Cố tình truy cập chỉ số ngoài phạm vi (10)

            // 🛑 Truy cập phần tử mảng. Vì index=10 vượt phạm vi, lỗi sẽ phát sinh.
            int value = numbers[index];

            // ⚠️ Dòng dưới sẽ không được thực thi nếu lỗi xảy ra
            System.out.println("Giá trị tại chỉ số " + index + ": " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            // 📌 Bắt lỗi truy cập chỉ số ngoài phạm vi mảng và in ra thông báo
            System.out.println("Lỗi ArrayIndexOutOfBoundsException: Chỉ số vượt quá phạm vi mảng!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc bình thường.");
    }
}

package Exceptions.UncheckedExceptions;

/**
 * 📝 NegativeArraySizeException:
 * - Là một runtime (unchecked) exception trong Java.
 * - Xảy ra khi bạn cố gắng tạo mảng với kích thước âm.
 * - Lỗi logic thường gặp khi biến xác định kích thước mảng được tính toán sai hoặc nhập từ người dùng không hợp lệ.
 */
public class NegativeArraySizeExceptionExample {
    public static void main(String[] args) {
        int size = -5; // ⚠️ Cố tình gán giá trị âm để gây ra lỗi

        try {
            // 🛑 Tạo mảng với kích thước âm → sẽ ném NegativeArraySizeException
            int[] arr = new int[size];

            // ⚠️ Dòng dưới sẽ không được thực thi nếu có lỗi xảy ra
            System.out.println("Mảng được tạo với kích thước: " + arr.length);

        } catch (NegativeArraySizeException e) {
            // 📌 Bắt lỗi kích thước mảng âm và in ra thông báo
            System.out.println("Lỗi NegativeArraySizeException: Không thể tạo mảng với kích thước âm!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc bình thường.");
    }
}

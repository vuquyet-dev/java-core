package Exceptions;
/*
 * ================================
 * 🎯 GHI CHÚ VỀ throw vs throws
 * ================================
 *
 * ✅ throw:
 *  - Là từ khóa DÙNG TRONG THÂN PHƯƠNG THỨC để CHỦ ĐỘNG NÉM (PHÁT SINH) một ngoại lệ cụ thể.
 *  - Khi 'throw' được thực thi, chương trình sẽ NGỪNG chạy hàm hiện tại ngay lập tức
 *    và tìm khối try-catch gần nhất để xử lý ngoại lệ.
 *  - Nếu không có try-catch bắt ngoại lệ, chương trình sẽ kết thúc bất thường với lỗi (stack trace).
 *  - Ví dụ:
 *        if (age < 0) {
 *            throw new IllegalArgumentException("Tuổi không được âm!");
 *        }
 *
 * ✅ throws:
 *  - Là từ khóa DÙNG TRONG KHAI BÁO PHƯƠNG THỨC (chữ ký hàm) để KHAI BÁO cho người gọi biết
 *    rằng phương thức này CÓ THỂ NÉM một hoặc nhiều loại ngoại lệ.
 *  - Bắt buộc với CHECKED EXCEPTION: nếu phương thức phát sinh checked exception
 *    mà không bắt tại chỗ, phải khai báo 'throws' để nơi gọi xử lý.
 *  - Ví dụ:
 *        public void readFile() throws IOException {
 *            // Code đọc file có thể phát sinh IOException
 *        }
 *
 * ================================
 * 🔎 SỰ KHÁC BIỆT:
 * ----------------
 * - throw: NÉM NGOẠI LỆ THỰC SỰ xảy ra tại runtime nếu điều kiện không hợp lệ.
 * - throws: KHAI BÁO PHƯƠNG THỨC có khả năng ném ngoại lệ để trình biên dịch bắt buộc người gọi xử lý.
 *
 * ================================
 * 🔹 TÓM TẮT:
 * - throw: Hành động phát sinh lỗi ngay tại vị trí thực thi.
 * - throws: Lời cảnh báo cho người dùng hàm biết phương thức có thể phát sinh lỗi.
 *
 * ================================
 * 📌 GHI NHỚ:
 * - throw → dùng ngay bên trong code logic.
 * - throws → dùng ở khai báo phương thức.
 */

public class ThrowExample {
    public static void checkAge(int age) {
        // 📌 Kiểm tra điều kiện: nếu tuổi nhỏ hơn 18, ta muốn báo lỗi và không cho tiếp tục.
        if (age < 18) {
            /*
             * ✅ Từ khóa 'throw' được dùng để NÉM (phát sinh) một ngoại lệ theo ý lập trình viên.
             * ✅ Ngoại lệ ở đây là IllegalArgumentException - một loại unchecked exception
             *    thường được dùng khi tham số của phương thức không hợp lệ.
             * ✅ Sau khi thực hiện lệnh throw, chương trình sẽ dừng thực thi hàm hiện tại
             *    và tìm khối try-catch gần nhất (nếu có) để bắt ngoại lệ này.
             * ✅ Nếu không có khối try-catch nào bắt ngoại lệ, chương trình sẽ kết thúc
             *    với thông báo lỗi (stack trace) kèm message chỉ định trong ngoại lệ.
             */
            throw new IllegalArgumentException("Tuổi phải >= 18 để tiếp tục!");
        } else {
            System.out.println("Tuổi hợp lệ, tiếp tục xử lý...");
        }
    }

    public static void main(String[] args) {
        // 🚨 Gọi checkAge với tuổi không hợp lệ, sẽ phát sinh ngoại lệ ở hàm trên
        checkAge(16);

        // Dòng này sẽ không được in ra nếu xảy ra ngoại lệ mà không được bắt
        System.out.println("Chương trình kết thúc.");
    }
}

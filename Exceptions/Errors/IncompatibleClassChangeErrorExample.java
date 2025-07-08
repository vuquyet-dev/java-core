package Exceptions.Errors;

/**
 * 📝 IncompatibleClassChangeError:
 * - Là một Error trong Java, thuộc nhóm LinkageError.
 * - Xảy ra khi JVM phát hiện sự thay đổi không tương thích trong class khi chạy chương trình.
 * - Nguyên nhân thường gặp:
 *     ⚠️ Bạn biên dịch code với một version class, sau đó thay đổi class đó (ví dụ: đổi từ class thành interface hoặc ngược lại)
 *         nhưng không biên dịch lại tất cả các class liên quan → JVM nạp class cũ và mới bị mâu thuẫn.
 *     ⚠️ Hoặc thư viện bạn dùng thay đổi cấu trúc class không tương thích với code hiện tại.
 * - Đây là lỗi nghiêm trọng, thường xuất hiện khi có vấn đề trong quá trình build/deploy hoặc môi trường không đồng nhất class.
 */
public class IncompatibleClassChangeErrorExample {
    public static void main(String[] args) {
        try {
            // 🛑 Giả lập ném IncompatibleClassChangeError (thực tế lỗi này
            // xảy ra khi có vấn đề thật với class file, chứ không phải do code tự gây ra)
            throw new IncompatibleClassChangeError("Giả lập lỗi IncompatibleClassChangeError: class bị thay đổi không tương thích!");

        } catch (IncompatibleClassChangeError e) {
            // 📌 Bắt lỗi và hiển thị thông báo
            System.out.println("Lỗi IncompatibleClassChangeError: Đã có thay đổi không tương thích trong class!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc (dù lỗi kiểu này thường rất nghiêm trọng).");
    }
}

package Exceptions.CheckedExceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 📝 FileNotFoundException:
 * - Là một checked exception trong Java.
 * - Xảy ra khi chương trình cố gắng mở một tệp tin (file) mà không tồn tại hoặc không thể truy cập.
 * - Phát sinh khi sử dụng các class như FileInputStream, FileReader... với đường dẫn sai.
 * - Vì là checked exception, bắt buộc phải xử lý bằng try-catch hoặc khai báo throws.
 */
public class FileNotFoundExceptionExample {
    public static void main(String[] args) {
        try {
            // 🛑 Cố gắng mở file không tồn tại "non_existent_file.txt"
            File file = new File("non_existent_file.txt");
            FileInputStream fis = new FileInputStream(file);

            // ⚠️ Dòng dưới sẽ không được thực thi nếu lỗi xảy ra
            System.out.println("Đã mở file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException e) {
            // 📌 Bắt lỗi khi file không tồn tại, in thông tin chi tiết
            System.out.println("Lỗi FileNotFoundException: Không tìm thấy file được chỉ định!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc bình thường.");
    }
}

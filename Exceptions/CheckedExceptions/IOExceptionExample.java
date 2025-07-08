package Exceptions.CheckedExceptions;

import java.io.*;

/**
 * 📝 IOException:
 * - Là checked exception trong Java, thuộc gói java.io.
 * - Xảy ra khi có lỗi I/O (nhập/xuất) như:
 *     ⚠️ Lỗi khi đọc/ghi file.
 *     ⚠️ Lỗi khi kết nối network.
 *     ⚠️ Lỗi khi stream bị đóng hoặc không còn khả năng đọc/ghi.
 * - IOException là lớp cha của nhiều exception con như: FileNotFoundException, EOFException,...
 */
public class IOExceptionExample {
    public static void main(String[] args) {
        String fileName = "non_existing_file.txt";

        try {
            // 🛑 Cố gắng mở file không tồn tại → phát sinh FileNotFoundException (con của IOException)
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line = reader.readLine();
            System.out.println("Nội dung dòng đầu tiên: " + line);

            reader.close();

        } catch (IOException e) {
            // 📌 Bắt IOException (và các exception con như FileNotFoundException)
            System.out.println("Lỗi IOException: Có vấn đề khi xử lý file hoặc luồng I/O!");
            System.out.println("Thông tin chi tiết: " + e.getMessage());
        }

        System.out.println("Chương trình kết thúc bình thường.");
    }
}

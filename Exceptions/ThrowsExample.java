package Exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThrowsExample {

    // 📌 Phương thức này khai báo 'throws IOException'
    // ⏩ Nghĩa là phương thức này CÓ THỂ phát sinh IOException,
    //     người gọi phải xử lý (try-catch) hoặc tiếp tục throws ra ngoài.
    public static void readFile(String path) throws IOException {
        /*
         * ✅ Ví dụ về checked exception: IOException.
         * ✅ Đọc file luôn tiềm ẩn nguy cơ lỗi (file không tồn tại, không quyền truy cập, ...).
         * ✅ Vì vậy phải khai báo 'throws IOException' hoặc bắt bằng try-catch trong hàm này.
         */
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void main(String[] args) {
        try {
            // 📌 Gọi phương thức readFile() - vì phương thức này throws IOException
            //    nên bắt buộc phải đặt trong khối try-catch để bắt lỗi.
            readFile("test.txt");
        } catch (IOException e) {
            // ✅ Xử lý lỗi: In thông báo nếu có lỗi khi đọc file
            System.out.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
        }
        System.out.println("Chương trình kết thúc!");
    }
}


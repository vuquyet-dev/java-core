package stringClass; // Khai báo package chứa class này (tên thư mục là stringClass)


/*
 * ========================= String Class in Java =========================
 * ✔ String là một lớp đặc biệt trong Java dùng để xử lý chuỗi ký tự (text).
 * ✔ Chuỗi trong Java là immutable – không thể thay đổi sau khi khởi tạo.
 *
 * ✅ Một số phương thức phổ biến:
 *    - length():          trả về độ dài chuỗi
 *    - toUpperCase():     chuyển toàn bộ chuỗi sang chữ hoa
 *    - toLowerCase():     chuyển toàn bộ chuỗi sang chữ thường
 *    - split():           cắt chuỗi thành mảng con theo dấu phân cách
 *    - contains():        kiểm tra chuỗi có chứa chuỗi con không
 *    - replace():         thay thế một phần chuỗi bằng chuỗi khác
 *    - compareTo():       so sánh thứ tự từ điển giữa 2 chuỗi
 *
 * 🔹 Ngoài ra có thể dùng StringBuilder để xử lý chuỗi hiệu quả hơn khi cần thay đổi liên tục.
 *
 * 💡 String rất quan trọng trong Java Core, được dùng trong hầu hết mọi ứng dụng.
 */

public class StringExample {
    public static void main(String[] args) {

        // Khởi tạo chuỗi văn bản
        String text = "My name is vu van quyet, i am 22 years old";

        // In ra độ dài của chuỗi
        System.out.println("Length: " + text.length()); // → 44 ký tự

        // Chuyển tất cả ký tự trong chuỗi thành chữ in hoa
        System.out.println("Uppercase: " + text.toUpperCase());

        // Chuyển tất cả ký tự thành chữ thường
        System.out.println("Lowercase: " + text.toLowerCase());

        // Cắt chuỗi thành các từ, đếm số từ trong chuỗi
        String[] a = text.trim().split("\\s+"); // Dùng regex để tách theo khoảng trắng
        System.out.println("dem so tu: " + a.length); // → In ra số từ trong câu

        // Dùng StringBuilder để đảo ngược chuỗi
        StringBuilder sb = new StringBuilder(text);
        System.out.println(sb.reverse().toString()); // → In ra chuỗi đảo ngược

        // Kiểm tra xem chuỗi có chứa từ "name" không
        if(text.contains("name")) {
            System.out.println("true"); // Nếu có in ra true
        } else {
            System.out.println(false); // Nếu không có in ra false
        }

        // Thay thế từ "name" bằng "ten" trong chuỗi
        System.out.println(text.replace("name", "ten"));

        // So sánh chuỗi hiện tại với chính nó
        System.out.println(text.compareTo("My name is vu van quyet, i am 22 years old"));
        // → Kết quả là 0 vì giống hệt
    }
}

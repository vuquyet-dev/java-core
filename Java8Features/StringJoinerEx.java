package Java8Features;

/**
 * 📌 Giới thiệu về StringJoiner:
 * - StringJoiner (java.util.StringJoiner) được giới thiệu từ Java 8 để hỗ trợ nối chuỗi (joining) linh hoạt, thay thế
 *   cho việc tự xử lý StringBuilder/vòng lặp khi ghép nhiều chuỗi lại với nhau.
 * - Bạn có thể chỉ định:
 *   ✅ delimiter (dấu phân cách),
 *   ✅ optional prefix (chuỗi thêm vào đầu), tùy chọn tiền tố
 *   ✅ optional suffix (chuỗi thêm vào cuối). tùy chọn hậu tố
 * - Nó được thiết kế gọn nhẹ, dễ sử dụng, đồng thời tối ưu hơn khi cần nối số lượng lớn chuỗi.
 * - Các phương thức chính:
 *   ➡ add()      : thêm một phần tử vào chuỗi.
 *   ➡ merge()    : nối 2 StringJoiner lại.
 *   ➡ setEmptyValue(): đặt giá trị trả về khi chưa add phần tử nào.
 *   ➡ length()   : độ dài hiện tại của chuỗi.
 *   ➡ toString() : xuất ra chuỗi cuối cùng.
 */

import java.util.StringJoiner;

public class StringJoinerEx {
    public static void main(String[] args) {
        // ✅ Tạo StringJoiner với dấu phẩy, prefix "[" và suffix "]"
        StringJoiner sj = new StringJoiner(", ", "[", "]");

        // Thêm các phần tử
        sj.add("Java");
        sj.add("Python");
        sj.add("C++");

        System.out.println("Kết quả sau khi add: " + sj); // -> [Java, Python, C++]

        // ✅ Lấy độ dài chuỗi hiện tại
        System.out.println("Độ dài chuỗi: " + sj.length()); // tính cả prefix, suffix, dấu phân cách

        // ✅ setEmptyValue(): nếu chưa có phần tử nào, sẽ trả giá trị chỉ định
        StringJoiner emptySJ = new StringJoiner(", ", "{", "}");
        emptySJ.setEmptyValue("EMPTY");
        System.out.println("Empty StringJoiner: " + emptySJ); // -> EMPTY

        // ✅ merge(): gộp chuỗi từ một StringJoiner khác
        StringJoiner sj2 = new StringJoiner(" | ", "(", ")");
        sj2.add("Ruby").add("Go");
        sj.merge(sj2);
        System.out.println("Sau merge: " + sj); // -> [Java, Python, C++, Ruby | Go]

        // ✅ Ví dụ trường hợp chưa add nhưng setEmptyValue rồi thì sẽ hiển thị giá trị setEmptyValue
        StringJoiner emptyExample = new StringJoiner(", ", "<", ">");
        emptyExample.setEmptyValue("Không có phần tử nào");
        System.out.println("Empty Example: " + emptyExample); // -> Không có phần tử nào

        // ✅ Chuyển thành chuỗi cuối cùng
        String result = sj.toString();
        System.out.println("Chuỗi cuối cùng: " + result);
    }
}


package RegularExpression;

import java.util.regex.*; // ✅ Import thư viện regex của Java

public class RegexAllMethodsDemo {
    public static void main(String[] args) {
        // ✅ Tạo Pattern với regex: "(\\d{2})-(\\w+)"
        // Khớp: 2 chữ số + dấu '-' + 1 hoặc nhiều ký tự chữ, không phân biệt hoa thường, hỗ trợ multiline
        Pattern pattern = Pattern.compile("(\\d{2})-(\\w+)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

        // ✅ Chuỗi để tìm kiếm
        String text = "12-abc\n34-DEF\n56-Ghi";

        // ✅ Tạo Matcher từ pattern & text
        Matcher matcher = pattern.matcher(text);

        // ✅ Dùng find() lặp qua từng kết quả khớp
        while (matcher.find()) {
            System.out.println("🔹 Found: " + matcher.group()); // Toàn bộ kết quả khớp

            // ✅ Lấy các nhóm (group1: 2 chữ số, group2: chữ cái)
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("   ✨ Group " + i + ": " + matcher.group(i));
            }

            // ✅ start(), end(): Vị trí bắt đầu/kết thúc của khớp trong chuỗi
            System.out.println("   📌 Starts at: " + matcher.start() + ", ends at: " + matcher.end());
        }

        // ✅ reset() giúp đặt lại matcher về trạng thái ban đầu để quét lại từ đầu
        matcher.reset();

        // ✅ lookingAt() kiểm tra xem pattern khớp ngay từ đầu chuỗi không
        if (matcher.lookingAt()) {
            System.out.println("📌 lookingAt: Chuỗi bắt đầu khớp pattern");
        } else {
            System.out.println("📌 lookingAt: Không khớp ngay đầu chuỗi");
        }

        // ✅ matches() kiểm tra toàn bộ chuỗi có khớp pattern không
        if (matcher.matches()) {
            System.out.println("📌 matches: Toàn bộ chuỗi khớp pattern");
        } else {
            System.out.println("📌 matches: Toàn bộ chuỗi KHÔNG khớp pattern");
        }

        // ✅ replaceAll(): thay tất cả các kết quả khớp bằng "XX-" + group2 (chữ cái)
        String replacedAll = matcher.replaceAll("XX-$2");

        // ✅ replaceFirst(): chỉ thay kết quả khớp đầu tiên bằng "YY-" + group2
        String replacedFirst = matcher.replaceFirst("YY-$2");

        // ✅ In kết quả thay thế
        System.out.println("🔹 replaceAll: " + replacedAll);
        System.out.println("🔹 replaceFirst: " + replacedFirst);

        // ✅ usePattern() để thay đổi pattern mà matcher đang sử dụng
        Pattern newPattern = Pattern.compile("\\w+"); // Khớp các chuỗi từ (chữ + số)
        matcher.usePattern(newPattern); // Gán pattern mới cho matcher

        matcher.reset(); // Reset matcher để quét lại với pattern mới

        // ✅ Tìm các từ khớp pattern mới trong chuỗi
        while (matcher.find()) {
            System.out.println("🔹 usePattern match: " + matcher.group());
        }

        // ✅ region() giới hạn matcher chỉ quét từ vị trí 7 đến cuối chuỗi
        matcher.reset(text); // Reset với chuỗi gốc ban đầu
        matcher.region(7, text.length()); // Đặt vùng quét: từ ký tự thứ 7

        // ✅ Tìm trong vùng quét đã đặt
        while (matcher.find()) {
            System.out.println("🔹 region match: " + matcher.group());
        }

        // ✅ hitEnd() kiểm tra nếu matcher đã quét đến cuối chuỗi (thường dùng khi xử lý stream)
        // ✅ requireEnd() cho biết nếu cần thêm dữ liệu để xác định kết quả khớp
        matcher.reset("56-Ghi"); // Đặt matcher về chuỗi mới ngắn hơn
        matcher.find(); // Tìm khớp trong chuỗi này

        // ✅ In trạng thái hitEnd và requireEnd
        System.out.println("📌 hitEnd: " + matcher.hitEnd());
        System.out.println("📌 requireEnd: " + matcher.requireEnd());

        // ✅ pattern() trả về pattern hiện tại matcher đang sử dụng
        Pattern currentPattern = matcher.pattern();
        System.out.println("📌 Current pattern: " + currentPattern.pattern());

        // ✅ flags() trả về flags của pattern hiện tại
        System.out.println("📌 Flags: " + currentPattern.flags());
    }
}

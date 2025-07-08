package DateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 📅 GIỚI THIỆU VỀ DATE & TIME TRONG JAVA
 *
 * Java cung cấp API hiện đại để xử lý ngày và giờ trong gói java.time (từ Java 8 trở lên),
 * giúp thao tác với thời gian trở nên rõ ràng, chính xác và an toàn luồng (thread-safe).
 *
 * ✔ Các lớp chính:
 *   - LocalDate: đại diện cho ngày (không có giờ)
 *   - LocalTime: đại diện cho giờ (không có ngày)
 *   - LocalDateTime: cả ngày và giờ (không có múi giờ)
 *   - ZonedDateTime: ngày, giờ và múi giờ (TimeZone)
 *   - Instant: mốc thời gian chính xác theo UTC (timestamp)
 *   - Duration: khoảng thời gian giữa hai thời điểm (giờ, phút, giây)
 *   - Period: khoảng thời gian giữa hai ngày (năm, tháng, ngày)
 *   - DateTimeFormatter: định dạng và phân tích chuỗi ngày giờ
 *
 * ⚠ Ngoài ra, còn có các lớp hỗ trợ như ChronoUnit (đo lường chính xác)
 *
 * 📌 Ưu điểm của java.time:
 *   - Không mutable (bất biến), an toàn khi dùng đa luồng.
 *   - Cú pháp rõ ràng, dễ đọc và dễ bảo trì.
 *   - Hỗ trợ tốt múi giờ và định dạng ngày giờ quốc tế.
 *
 * 🔰 Ghi chú:
 *   - Không nên dùng java.util.Date hoặc Calendar trong dự án mới.
 *   - Nếu làm việc với cơ sở dữ liệu, có thể cần convert giữa java.time và java.sql.
 *
 * 👉 Ví dụ này sẽ minh họa cách sử dụng hầu hết các lớp trên để xử lý ngày giờ một cách linh hoạt và hiện đại.
 */
public class dateTimeExample {

    public static void main(String[] args) {
        // 🔹 1. LocalDate - chỉ ngày (không có giờ)
        LocalDate today = LocalDate.now();
        System.out.println("📅 Ngày hôm nay: " + today);

        // Lấy các thành phần của ngày
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.println("🗓 Chi tiết: Năm: " + year + ", Tháng: " + month + ", Ngày: " + day);

        // 🔹 2. LocalTime - chỉ giờ (không có ngày)
        LocalTime nowTime = LocalTime.now();
        System.out.println("⏰ Giờ hiện tại: " + nowTime);

        // Lấy giờ, phút, giây
        System.out.println("🕒 Giờ: " + nowTime.getHour() + ", Phút: " + nowTime.getMinute() + ", Giây: " + nowTime.getSecond());

        // 🔹 3. LocalDateTime - ngày và giờ (không múi giờ)
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("🧭 Ngày & Giờ hiện tại: " + nowDateTime);

        // Cộng thêm 3 ngày, trừ 2 giờ
        LocalDateTime future = nowDateTime.plusDays(3).minusHours(2);
        System.out.println("📆 Sau 3 ngày, trừ 2 giờ: " + future);

        // 🔹 4. ZonedDateTime - có múi giờ
        ZonedDateTime zonedNow = ZonedDateTime.now();
        System.out.println("🌍 Giờ toàn cầu (có múi giờ): " + zonedNow);

        // Lấy giờ ở múi giờ khác (vd: Tokyo)
        ZonedDateTime tokyoTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("🗾 Giờ ở Tokyo: " + tokyoTime);

        // 🔹 5. Instant - thời điểm chính xác theo UTC (dùng cho timestamp)
        Instant timestamp = Instant.now();
        System.out.println("🕘 Timestamp (UTC): " + timestamp);

        // 🔹 6. Duration - khoảng cách thời gian (giờ, phút, giây)
        Duration duration = Duration.between(LocalTime.now(), LocalTime.now().plusHours(2));
        System.out.println("⏳ Khoảng thời gian 2 giờ: " + duration.toHours() + " giờ");

        // 🔹 7. Period - khoảng cách ngày/tháng/năm
        LocalDate dob = LocalDate.of(2000, 6, 26);
        Period age = Period.between(dob, today);
        System.out.println("🎂 Tuổi: " + age.getYears() + " năm, " + age.getMonths() + " tháng, " + age.getDays() + " ngày");

        // 🔹 8. DateTimeFormatter - định dạng ngày giờ
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatted = nowDateTime.format(formatter);
        System.out.println("🖨 Ngày giờ định dạng: " + formatted);

        // Parse chuỗi thành ngày giờ
        String input = "01/01/2025 08:30:00";
        LocalDateTime parsedDateTime = LocalDateTime.parse(input, formatter);
        System.out.println("📥 Chuỗi đã parse: " + parsedDateTime);

        // 🔹 9. ChronoUnit - đo độ chênh lệch ngày chính xác
        long daysBetween = ChronoUnit.DAYS.between(dob, today);
        System.out.println("📏 Số ngày từ ngày sinh đến nay: " + daysBetween + " ngày");
    }
}

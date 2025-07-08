package Exceptions.CheckedExceptions;

/**
 * 📝 InterruptedException:
 * - Là một checked exception trong Java.
 * - Xảy ra khi một luồng (thread) đang **chờ, ngủ hoặc đang bị block** thì bị luồng khác gọi interrupt.
 * - Ví dụ hay gặp:
 *     ⚠️ Gọi Thread.sleep() → luồng bị ngắt bởi một thread khác → phát sinh InterruptedException.
 * - Thường dùng để kết thúc luồng đang chạy dài khi cần dừng chương trình.
 */
public class InterruptedExceptionExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Thread bắt đầu ngủ 5 giây...");
                Thread.sleep(5000); // 🛌 Ngủ 5 giây

                // ⚠️ Dòng dưới sẽ không được chạy nếu bị ngắt
                System.out.println("Thread tỉnh dậy bình thường!");

            } catch (InterruptedException e) {
                // 📌 Xử lý nếu thread bị ngắt trong khi ngủ
                System.out.println("Thread đã bị ngắt! Thông tin chi tiết: " + e.getMessage());
            }
        });

        thread.start();

        try {
            Thread.sleep(1000); // Cho main thread chờ 1 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread sẽ ngắt thread con...");
        thread.interrupt(); // 🛑 Ngắt thread con → phát sinh InterruptedException trong thread con

        System.out.println("Chương trình kết thúc bình thường.");
    }
}

package Asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
/*
 * ==========================
 * 📌 GIỚI THIỆU: ASYNCHRONOUS TRONG JAVA
 * ==========================
 *
 * ✅ Asynchronous (bất đồng bộ) là một kỹ thuật cho phép chương trình thực hiện nhiều tác vụ cùng lúc
 * mà không cần phải chờ từng tác vụ hoàn thành theo thứ tự như cách xử lý đồng bộ (synchronous).
 * Trong bất đồng bộ, một tác vụ có thể "chạy nền", và chương trình vẫn tiếp tục xử lý các tác vụ khác.
 *
 * 🔹 Java hỗ trợ bất đồng bộ thông qua nhiều công cụ:
 *   - Thread (luồng)
 *   - ExecutorService (bộ điều phối luồng)
 *   - CompletableFuture (từ Java 8, hỗ trợ fluent API để xử lý chuỗi tác vụ bất đồng bộ)
 *   - Reactive programming với Spring WebFlux (dựa trên Project Reactor)
 *
 * ==========================
 * ✅ ƯU ĐIỂM CỦA ASYNCHRONOUS
 * ==========================
 * ✨ Tăng hiệu suất hệ thống: Nhiều tác vụ chạy song song → tận dụng CPU tốt hơn.
 * ✨ Không chặn luồng chính: Ứng dụng không bị đứng, đặc biệt quan trọng với UI hoặc API.
 * ✨ Phù hợp với các tác vụ I/O, gọi API, truy vấn DB, xử lý nền...
 *
 * ==========================
 * ⚠️ NHƯỢC ĐIỂM CỦA ASYNCHRONOUS
 * ==========================
 * ❗ Khó debug hơn so với đồng bộ vì luồng xử lý không theo thứ tự tuyến tính.
 * ❗ Quản lý lỗi và đồng bộ kết quả giữa các tác vụ trở nên phức tạp.
 * ❗ Viết code bất đồng bộ cần hiểu rõ về callback, future, promise hoặc reactive stream.
 *
 * ==========================
 * ✨ KẾT LUẬN
 * ==========================
 * Việc sử dụng bất đồng bộ đúng cách sẽ giúp ứng dụng phản hồi nhanh hơn, tiết kiệm tài nguyên và
 * mang lại trải nghiệm người dùng tốt hơn. Tuy nhiên, nó đòi hỏi kiến thức kỹ thuật vững chắc để
 * xử lý tốt các vấn đề liên quan đến đồng bộ, xử lý lỗi, và maintain code.
 */

public class AsyncOrderSystem {

    // Mô phỏng kiểm tra kho (mất 2 giây)
    public static CompletableFuture<String> checkInventory(String product) {//Tạo một CompletableFuture<String>.
        return CompletableFuture.supplyAsync(() -> {// Tạo một tác vụ chạy bất đồng bộ trong background thread, đồng thời trả về giá trị sau khi xử lý.
            //lambda không nhận đầu vào, trả về là 1 biểu thức
            simulateDelay(2);//Gọi hàm mô phỏng độ trễ
            System.out.println("✅ Kiểm tra kho cho sản phẩm: " + product);
            return "Còn hàng";//Do đây là supplyAsync, nên bạn phải có return.
        });
    }

    // Mô phỏng xử lý thanh toán (mất 3 giây)
    public static CompletableFuture<String> processPayment(String user) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay(3);
            System.out.println("💳 Xử lý thanh toán cho người dùng: " + user);
            return "Thanh toán thành công";
        });
    }

    // Mô phỏng gửi email (mất 1 giây)
    public static CompletableFuture<Void> sendConfirmationEmail(String user) {//Tác vụ không trả về kết quả, nên dùng CompletableFuture<Void>.
        return CompletableFuture.runAsync(() -> {//runAsync() dùng để chạy một lambda expression không tham số (không đầu vào, không trả về gì).
            simulateDelay(1);
            System.out.println("📧 Gửi email xác nhận đến: " + user);
        });
    }

    // Mô phỏng độ trễ
    public static void simulateDelay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);//TimeUnit.SECONDS.sleep(3); tương đương Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    // Hàm main: thực hiện toàn bộ quy trình đặt hàng
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String product = "Laptop Dell";
        String user = "nguyenvana@example.com";

        System.out.println("🚀 Bắt đầu đặt hàng...");

        // Bước 1: Kiểm tra kho và thanh toán chạy song song
        CompletableFuture<String> inventoryFuture = checkInventory(product);    //mô phỏng kiểm tra tồn kho (2 giây)
        CompletableFuture<String> paymentFuture = processPayment(user);         //mô phỏng xử lý thanh toán (3 giây)

        // Bước 2: Khi cả 2 hoàn tất, tiếp tục gửi email xác nhận
        CompletableFuture<Void> orderProcess = CompletableFuture.allOf(inventoryFuture, paymentFuture)//Đợi tất cả CompletableFuture bên trong hoàn tất(inventoryFuture, paymentFuture), xong thì mới tiếp tục.
                .thenRun(() -> {//Khi hoàn tất tất cả Future, chạy tiếp đoạn code không cần kết quả trả về.
                    try {
                        //  Lấy kết quả từ 2 CompletableFuture
                        String inventoryStatus = inventoryFuture.get();//.get() chờ và trả kết quả (blocking)
                        String paymentStatus = paymentFuture.get();

                        System.out.println("📦 Trạng thái kho: " + inventoryStatus);
                        System.out.println("💰 Trạng thái thanh toán: " + paymentStatus);

                        // Gửi email xác nhận
                        sendConfirmationEmail(user).join();//.join() để chờ gửi xong email trước khi in "Thành công".

                        System.out.println("🎉 Đặt hàng thành công!");
                    } catch (Exception e) {
                        System.out.println("❌ Có lỗi xảy ra: " + e.getMessage());
                    }
                });

        // Đợi tất cả hoàn tất
        orderProcess.get();
    }
}

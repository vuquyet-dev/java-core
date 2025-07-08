package Asynchronous;

import java.util.concurrent.*;
import java.util.*;

// 🧠 Hệ thống đặt vé máy bay bất đồng bộ
public class FlightBookingSystem {

    // 🧾 Danh sách chuyến bay với số ghế còn lại (giả lập bằng ConcurrentHashMap để xử lý đa luồng)
    static Map<String, Integer> seatInventory = new ConcurrentHashMap<>();//HashMap đồng bộ lưu số lượng ghế còn lại cho từng chuyến bay.

    // 🔧 Khởi tạo số ghế ban đầu
    static {
        seatInventory.put("VN123", 2);
        seatInventory.put("VN456", 1);
        seatInventory.put("VN789", 0); // chuyến này hết vé
    }

    // ✅ 1. Kiểm tra và giữ ghế cho chuyến bay nếu còn
    public static CompletableFuture<Boolean> checkAndReserveSeat(String flightCode) {
        return CompletableFuture.supplyAsync(() -> {
            synchronized (seatInventory) { // đảm bảo không 2 người cùng giữ 1 ghế khi nhiều luồng cùng đọc/ghi dữ liệu vào đối tượng đó.

                //Lấy số lượng ghế còn trống (available) từ seatInventory ứng với flightCode.
                if (seatInventory.containsKey(flightCode)) {
                    //ở dưới không cần getOrDefault bởi vì điều kiền ở trên là nếu key tồn tại mới thực hiện
                    int available = seatInventory.getOrDefault(flightCode, 0);//Nếu flightCode không tồn tại trong seatInventory, trả về mặc định là 0.
                    if(available > 0){
                        seatInventory.put(flightCode, available - 1); // giữ ghế
                        System.out.println("✅ Giữ chỗ thành công. Ghế còn lại: " + (available - 1));
                        return true;
                    }else {
                        System.out.println("❌ Hết vé cho chuyến bay " + flightCode);
                        return false;
                    }
                } else {
                    System.out.println("❌ Không tồn tại chuyến bay: " + flightCode);
                    return false;
                }
            }
        });
    }

    // 💳 2. Xử lý thanh toán
    public static CompletableFuture<Boolean> processPayment(String user) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay(2); // mô phỏng mất 2 giây xử lý thanh toán
            System.out.println("💳 Thanh toán thành công cho " + user);
            return true;
        });
    }

    // 📧 3. Gửi email xác nhận vé
    public static CompletableFuture<Void> sendConfirmation(String user, String flightCode) {
        return CompletableFuture.runAsync(() -> {
            simulateDelay(1);
            System.out.println("📧 Gửi email xác nhận cho " + user + " chuyến " + flightCode);
        });
    }

    // 🔄 4. Trả lại ghế nếu thanh toán lỗi
    public static CompletableFuture<Void> releaseSeat(String flightCode) {
        return CompletableFuture.runAsync(() -> {
            synchronized (seatInventory) {//giúp đồng bộ hóa truy cập giữa các luồng (thread), để tránh xung đột dữ liệu khi nhiều luồng cùng đọc/ghi vào cùng một tài nguyên
                if (seatInventory.containsKey(flightCode)) {
                    int current = seatInventory.get(flightCode);
                    seatInventory.put(flightCode, current + 1);
                    System.out.println("🔁 Đã trả lại ghế cho chuyến " + flightCode);
                }
            }
        });
    }

    // 💤 Mô phỏng độ trễ
    public static void simulateDelay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // 🚀 Hàm main – mô phỏng quá trình đặt vé
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String flightCode = "VN456"; // đổi thành "VN789" để thử tình huống hết chỗ
        String user = "nguyenvana@example.com";

        System.out.println("🚀 Bắt đầu quy trình đặt vé cho " + user);

        CompletableFuture<Void> bookingFlow = checkAndReserveSeat(flightCode)
                .thenCompose(seatReserved -> {//Dùng khi bạn muốn tiếp tục chuỗi bất đồng bộ với 1 hàm cũng trả về CompletableFuture
                    if (!seatReserved) return CompletableFuture.completedFuture(null);

                    return processPayment(user).thenCompose(paymentSuccess -> {
                        if (!paymentSuccess) {
                            return releaseSeat(flightCode); // nếu thanh toán lỗi thì trả ghế
                        }
                        return sendConfirmation(user, flightCode); // nếu thanh toán OK thì gửi email
                    });
                })
                .exceptionally(ex -> {
                    System.out.println("❗ Có lỗi xảy ra trong quá trình đặt vé: " + ex.getMessage());
                    return null;
                });

        bookingFlow.get(); // đợi mọi thứ hoàn thành
        System.out.println("✅ Kết thúc quy trình đặt vé.");
    }
}

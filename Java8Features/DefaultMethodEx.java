package Java8Features;

/*
=========================================
🔰 GIỚI THIỆU VỀ DEFAULT METHOD
=========================================
✅ Từ Java 8, interface cho phép khai báo default method – nghĩa là
   bạn có thể định nghĩa sẵn phần cài đặt (implementation) ngay trong interface,
   thay vì chỉ khai báo abstract method như trước.

✅ Cú pháp:
    default <kiểu trả về> <tên phương thức>(tham số) {
        // phần cài đặt
    }

✅ Mục đích:
  - Đảm bảo tính tương thích ngược (backward compatibility) cho các thư viện:
    Khi bạn muốn bổ sung phương thức mới vào interface cũ,
    nếu dùng abstract method thì mọi class đã implement interface đó sẽ phải sửa code.
    Nhưng nếu dùng default method, các class cũ sẽ tự động kế thừa hành vi mặc định,
    không bị lỗi biên dịch.

  - Hỗ trợ chia sẻ logic mặc định giữa nhiều class mà không cần duplicate code.
 */

// Định nghĩa một interface với default method
interface Engine {
    // Abstract method - phải implement ở class
    void start();

    // Default method - có sẵn hành vi mặc định
    default void stop() {
        System.out.println("Engine stopped (default).");
    }
}

// Một interface khác, cũng có default method trùng tên
interface GPS {
    default void stop() {
        System.out.println("GPS stopped (default).");
    }
}

// Class này implement Engine, không override default method stop()
class BasicCar implements Engine {
    @Override
    public void start() {
        System.out.println("BasicCar engine started.");
    }

    // Không override stop() -> sẽ dùng stop() của Engine
}

// Class này override default method stop()
class AdvancedCar implements Engine {
    @Override
    public void start() {
        System.out.println("AdvancedCar engine started.");
    }

    @Override
    public void stop() {
        System.out.println("AdvancedCar engine stopped (override).");
    }
}

// Class implement nhiều interface có default method trùng tên -> bắt buộc override stop()
class SmartCar implements Engine, GPS {
    @Override
    public void start() {
        System.out.println("SmartCar engine started.");
    }

    // Bắt buộc override vì có xung đột giữa Engine.stop() và GPS.stop()
    @Override
    public void stop() {
        System.out.println("SmartCar combined stop:");
        // Gọi default method cụ thể bằng cú pháp Interface.super.method()
        Engine.super.stop();
        GPS.super.stop();
    }
}

// Main để chạy thử
public class DefaultMethodEx {
    public static void main(String[] args) {
        // BasicCar dùng default method của Engine
        Engine basic = new BasicCar();
        basic.start();       // "BasicCar engine started."
        basic.stop();        // "Engine stopped (default)."

        System.out.println("----");

        // AdvancedCar override default method
        Engine advanced = new AdvancedCar();
        advanced.start();    // "AdvancedCar engine started."
        advanced.stop();     // "AdvancedCar engine stopped (override)."

        System.out.println("----");

        // SmartCar xử lý xung đột default method
        SmartCar smart = new SmartCar();
        smart.start();       // "SmartCar engine started."
        smart.stop();        // "SmartCar combined stop:"
        // "Engine stopped (default)."
        // "GPS stopped (default)."
    }
}

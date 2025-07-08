package MultiThreading;

// Lớp đại diện cho công việc của từng nhân viên (mỗi luồng)
class EmployeeTask extends Thread {
    private String task; // Tên công việc của nhân viên

    // Constructor nhận tên và công việc của nhân viên
    public EmployeeTask(String name, String task) {
        this.setName(name); // Đặt tên cho luồng
        this.task = task;
    }

    // Mỗi luồng sẽ chạy nội dung trong hàm run()
    @Override
    public void run() {
        System.out.println("🔹 " + getName() + " bắt đầu công việc: " + task);

        for (int i = 1; i <= 5; i++) {
            // Kiểm tra nếu luồng bị gián đoạn (bị interrupt)
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("⚠️ " + getName() + " bị gián đoạn công việc!");
                return;
            }

            System.out.println(getName() + " đang làm việc... bước " + i);

            try {
                Thread.sleep(500); // Giả lập thời gian làm việc là 0.5 giây
            } catch (InterruptedException e) {
                System.out.println("❌ " + getName() + " bị interrupt trong khi đang ngủ!");
                return;
            }
        }

        // Sau khi hoàn thành 5 bước
        System.out.println("✅ " + getName() + " hoàn thành công việc.");
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        // Tạo ra 3 nhân viên tương ứng 3 luồng
        EmployeeTask emp1 = new EmployeeTask("👷 Nhân viên A", "Nhập dữ liệu");
        EmployeeTask emp2 = new EmployeeTask("🧑‍💻 Nhân viên B", "Xử lý dữ liệu");
        EmployeeTask emp3 = new EmployeeTask("📊 Nhân viên C", "Lập báo cáo");

        // Đặt mức độ ưu tiên cho từng nhân viên
        emp1.setPriority(Thread.MAX_PRIORITY);    // Ưu tiên 10
        emp2.setPriority(Thread.NORM_PRIORITY);   // Ưu tiên 5
        emp3.setPriority(Thread.MIN_PRIORITY);    // Ưu tiên 1

        // Khởi động nhân viên A trước
        emp1.start();

        // Chờ nhân viên A hoàn thành thì mới chạy B và C
        emp1.join();

        // Chạy đồng thời B và C
        emp2.start();
        emp3.start();

        // Chờ 1 giây để emp2 và emp3 chạy vài bước, mỗi bước = 500ms cho nên 1000ms sẽ đủ 2 bước
        Thread.sleep(1000);

        // Kiểm tra trạng thái còn sống của 2 luồng
        System.out.println("📌 emp2 isAlive: " + emp2.isAlive());
        System.out.println("📌 emp3 isAlive: " + emp3.isAlive());

        // Ngắt luồng emp2 để mô phỏng lỗi/gián đoạn
        emp2.interrupt();

        // Chờ cả 2 luồng kết thúc
        emp2.join();
        emp3.join();

        // Khi tất cả đã hoàn tất
        System.out.println("🏁 Tất cả công việc đã hoàn tất.");
    }
}

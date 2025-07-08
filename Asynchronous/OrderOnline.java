package Asynchronous;

import java.util.HashMap;

import java.util.concurrent.CompletableFuture;

import java.util.concurrent.TimeUnit;

public class OrderOnline {
    static HashMap<String, Integer> order = new HashMap();

    static {
        order.put("Screen", 4);
        order.put("Phone", 14);
        order.put("Bag", 9);
        order.put("Led", 0);
        order.put("Tree", 10);
    }

    //Kiem tra ton kho
    public static CompletableFuture<Boolean> checkAvailable(String product) {
        return CompletableFuture.supplyAsync(() -> {
            synchronized (order) {
                if (order.containsKey(product)) {
                    int value = order.get(product);
                    if (value > 0) {
                        order.put(product, value - 1);
                        System.out.println("Mặt hàng " + product + " còn trong kho");
                        return true;
                    } else {
                        System.out.println("Mặt hàng " + product + " đã hết");
                        return false;
                    }
                } else {
                    System.out.println("Không có mặt hàng nào tên " + product);
                    return false;
                }
            }
        });
    }

    public static CompletableFuture<Boolean> paymentProcessing(String product, double money) {
        return CompletableFuture.supplyAsync(() -> {
            synchronized (order) {
                if (money > 100.0) {
                    simulate(2);
                    System.out.println("Thanh toán thành công cho sản phẩm " + product);
                    return true;
                } else {
                    System.out.println("Số tiền trong tài khoản quý khách không đủ");
                    return false;
                }
            }
        });
    }

    public static CompletableFuture<Void> errorPayment(String product) {
        return CompletableFuture.runAsync(() -> {
            synchronized (order) {
                int count = order.get(product);
                order.put(product, count + 1);
                System.out.println("Số lượng đơn hàng: " + order.get(product));
            }
        });
    }

    public static CompletableFuture<Void> prepare(String product) {
        return CompletableFuture.runAsync(() -> {
            simulate(1);
            System.out.println("Đơn hàng " + product + " đang chuẩn bị");
        });
    }

    public static CompletableFuture<Void> sendEmail(String email) {
        return CompletableFuture.runAsync(() -> {
            simulate(1);
            System.out.println("Đã gửi đến email " + email + " xác nhận đơn hàng");
        });
    }

    public static CompletableFuture<Boolean> updateStatus(String product, String confirm) {
        return CompletableFuture.supplyAsync(() -> {
            synchronized (order) {
                simulate(2);
                if (confirm.toLowerCase().equals("accept")) {
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    public static void simulate(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String productName = "Tree";
        String email = "quyet@gmail.com";
        double money = 111;
        String confirm = "Accept";

        CompletableFuture<Void> checkProduct = checkAvailable(productName).thenCompose(returnTrue -> {
            if (!returnTrue) {
                return CompletableFuture.completedFuture(null);
            }
            return paymentProcessing(productName, money).thenCompose(paymentSuccessful -> {
                if (!paymentSuccessful) {
                    return errorPayment(productName);
                }
                return CompletableFuture.allOf(prepare(productName), sendEmail(email))
                        .thenCompose(v -> updateStatus(productName, confirm)).thenAccept(returnStatus -> {
                            if (returnStatus) {
                                System.out.println("Cập nhật trạng thái: Xác nhận. Đơn hàng sẽ được giao trong thời gian sớm nhất");
                            } else {
                                System.out.println("Cập nhật trạng thái: Hủy. Bạn đã hủy đơn hàng");
                                errorPayment(productName);
                            }
                        });
            });
        });
        checkProduct.join();
    }


}
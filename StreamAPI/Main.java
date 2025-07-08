package StreamAPI;

import java.util.*;
import java.util.stream.*;
/**
 * 🔹 STREAM API TRONG JAVA
 *
 * ✅ Stream API là một phần của Java từ phiên bản Java 8,
 *    cho phép xử lý các tập dữ liệu theo cách **hàm** (functional programming)
 *    với **pipeline** gồm nhiều bước như filter, map, sort, collect...
 *
 * ✅ Mục tiêu:
 *    - Viết code ngắn gọn, rõ ràng và dễ bảo trì.
 *    - Hỗ trợ xử lý tuần tự hoặc song song (parallel).
 *
 * ✅ Đặc điểm:
 *    - Là một pipeline (dòng chảy dữ liệu).
 *    - Dữ liệu gốc **không bị thay đổi** (bất biến).
 *    - Có thể hoạt động **lazy** (chỉ tính toán khi cần thiết).
 *
 * ✅ Các thao tác chính:
 *    1. filter()     → Lọc phần tử theo điều kiện.
 *    2. map()        → Biến đổi phần tử.
 *    3. sorted()     → Sắp xếp.
 *    4. distinct()   → Loại bỏ trùng.
 *    5. limit(), skip() → Phân trang.
 *    6. forEach()    → Duyệt phần tử.
 *    7. collect()    → Gộp kết quả về List, Set, Map...
 *    8. reduce()     → Tính toán tổng, tích, nối chuỗi...
 *    9. anyMatch(), allMatch(), noneMatch() → Kiểm tra điều kiện.
 *   10. findFirst(), findAny() → Lấy phần tử.
 *   11. groupingBy(), partitioningBy() → Nhóm dữ liệu.
 *   12. summaryStatistics() → Thống kê nhanh.
 *
 * 📌 Lưu ý:
 *    - Stream chỉ được **duyệt một lần**.
 *    - Không nên dùng để thay thế mọi `for-loop`, chỉ dùng khi phù hợp.
 *
 * 📚 Ví dụ: Tính trung bình điểm của sinh viên, lọc sản phẩm giá > 100, nhóm theo loại,...
 */

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "iPhone", "Electronics", 999.99, 10),
                new Product(2, "MacBook", "Electronics", 1999.99, 5),
                new Product(3, "T-shirt", "Clothing", 19.99, 100),
                new Product(4, "Jeans", "Clothing", 39.99, 50),
                new Product(5, "AirPods", "Electronics", 199.99, 20),
                new Product(6, "Book", "Education", 9.99, 200),
                new Product(7, "Pen", "Education", 1.99, 500),
                new Product(8, "Shoes", "Clothing", 89.99, 30)
        );

        // 1. filter: Lọc sản phẩm có giá > 100
        System.out.println("✅ Sản phẩm giá > 100:");
        products.stream()
                .filter(p -> p.getPrice() > 100)
                .forEach(System.out::println);

        // 2. map: Lấy tên sản phẩm
        System.out.println("\n✅ Tên các sản phẩm:");
        products.stream()
                .map(Product::getName)
                .forEach(System.out::println);

        // 3. sorted: Sắp xếp theo giá tăng dần
        System.out.println("\n✅ Sắp xếp theo giá tăng dần:");
        products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .forEach(System.out::println);

        // 4. distinct: Tên các loại sản phẩm không trùng
        System.out.println("\n✅ Loại sản phẩm (distinct):");
        products.stream()
                .map(Product::getCategory)
                .distinct()
                .forEach(System.out::println);

        // 5. limit + skip: Bỏ 2 sản phẩm đầu, lấy 3 tiếp theo
        System.out.println("\n✅ Lấy 3 sản phẩm sau khi bỏ 2:");
        products.stream()
                .skip(2)
                .limit(3)
                .forEach(System.out::println);

        // 6. anyMatch, allMatch, noneMatch
        System.out.println("\n✅ Kiểm tra điều kiện:");
        System.out.println("Có sản phẩm nào < 10$ không? " +
                products.stream().anyMatch(p -> p.getPrice() < 10));
        System.out.println("Tất cả sản phẩm > 1$? " +
                products.stream().allMatch(p -> p.getPrice() > 1));
        System.out.println("Không có sản phẩm nào giá âm? " +
                products.stream().noneMatch(p -> p.getPrice() < 0));

        // 7. findFirst + findAny
        System.out.println("\n✅ Sản phẩm đầu tiên:");
        products.stream().findFirst().ifPresent(System.out::println);

        System.out.println("✅ Bất kỳ sản phẩm nào thuộc 'Clothing':");
        products.stream()
                .filter(p -> p.getCategory().equals("Clothing"))
                .findAny()
                .ifPresent(System.out::println);

        // 8. max + min
        System.out.println("\n✅ Sản phẩm giá cao nhất:");
        products.stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                .ifPresent(System.out::println);

        System.out.println("✅ Sản phẩm giá thấp nhất:");
        products.stream()
                .min(Comparator.comparingDouble(Product::getPrice))
                .ifPresent(System.out::println);

        // 9. reduce: Tính tổng số lượng sản phẩm
        int totalQuantity = products.stream()
                .map(Product::getQuantity)
                .reduce(0, Integer::sum);
        System.out.println("\n✅ Tổng số lượng tất cả sản phẩm: " + totalQuantity);

        // 10. collect to List
        System.out.println("\n✅ Danh sách sản phẩm 'Electronics':");
        List<Product> electronics = products.stream()
                .filter(p -> p.getCategory().equals("Electronics"))
                .collect(Collectors.toList());
        electronics.forEach(System.out::println);

        // 11. groupingBy: Nhóm sản phẩm theo category
        System.out.println("\n✅ Nhóm sản phẩm theo loại:");
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        grouped.forEach((k, v) -> {
            System.out.println("🔸 " + k + ":");
            v.forEach(p -> System.out.println("   - " + p));
        });

        // 12. partitioningBy: Chia sản phẩm >100 và còn lại
        System.out.println("\n✅ Chia sản phẩm theo giá > 100:");
        Map<Boolean, List<Product>> partitioned = products.stream()
                .collect(Collectors.partitioningBy(p -> p.getPrice() > 100));
        partitioned.forEach((k, v) -> {
            System.out.println(k ? "🔸 > 100$:" : "🔹 <= 100$:");
            v.forEach(p -> System.out.println("   - " + p));
        });

        // 13. joining: Ghép tên sản phẩm thành chuỗi
        String names = products.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));
        System.out.println("\n✅ Danh sách tên sản phẩm: " + names);

        // 14. summary statistics
        DoubleSummaryStatistics stats = products.stream()
                .collect(Collectors.summarizingDouble(Product::getPrice));
        System.out.println("\n✅ Thống kê giá sản phẩm:");
        System.out.println("Tổng: " + stats.getSum());
        System.out.println("Trung bình: " + stats.getAverage());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
    }
}

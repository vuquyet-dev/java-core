package Java8Features;

import java.util.*;
import java.util.function.*;
import static java.util.stream.Collectors.*;

/**
 * 📌 Giới thiệu về Collectors:
 * - Collectors là một utility class trong java.util.stream, cung cấp tập hợp các phương thức tĩnh (static method)
 *   để giúp dễ dàng thu thập (collect) kết quả Stream thành các cấu trúc dữ liệu khác nhau hoặc thực hiện các phép tính tổng hợp.
 *
 * - Collectors thường được dùng với phương thức terminal collect() của Stream:
 *      stream.collect(Collectors.<method>())
 *
 * - Một số nhóm chức năng chính:
 *   ✅ Thu thập về Collection:
 *      - toList(), toSet(), toCollection()
 *   ✅ Thống kê & Tính toán:
 *      - counting(), summingInt(), averagingInt(), summarizingInt()
 *   ✅ Biến đổi thành chuỗi:
 *      - joining()
 *   ✅ Biến đổi thành Map:
 *      - toMap()
 *   ✅ Phân nhóm hoặc phân vùng:
 *      - groupingBy(), partitioningBy()
 *   ✅ Kết hợp collector khác:
 *      - mapping(), reducing(), collectingAndThen()
 *
 * - Lợi ích:
 *   🔹 Giúp code xử lý dữ liệu gọn gàng, dễ đọc, tránh vòng lặp for lồng nhau.
 *   🔹 Hỗ trợ mạnh mẽ cho lập trình hàm trong Java 8+.
 *   🔹 Tích hợp sâu với Stream API, rất quan trọng trong xử lý Collection lớn.
 */


public class CollectorsEx {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Anna", "Brian");

        // ✅ Collect vào List
        List<String> list = names.stream()
                .collect(toList());
        System.out.println("toList(): " + list); // [Alice, Bob, Charlie, Anna, Brian]

        // ✅ Collect vào Set (loại bỏ trùng lặp nếu có)
        Set<String> set = names.stream()
                .collect(toSet());
        System.out.println("toSet(): " + set);

        // ✅ Collect vào Collection tự định nghĩa (ví dụ LinkedList)
        LinkedList<String> linkedList = names.stream()
                .collect(toCollection(LinkedList::new));
        System.out.println("toCollection(LinkedList): " + linkedList);

        // ✅ Join thành chuỗi với phân tách, prefix và suffix
        String joined = names.stream()
                .collect(joining(", ", "Names: [", "]"));
        System.out.println("joining(): " + joined); // Names: [Alice, Bob, Charlie, Anna, Brian]

        // ✅ Đếm số phần tử
        long count = names.stream()
                .collect(counting());
        System.out.println("counting(): " + count); // 5

        // ✅ Tính giá trị trung bình độ dài tên
        double avgLength = names.stream()
                .collect(averagingInt(String::length));
        System.out.println("averagingInt(): " + avgLength);

        // ✅ Tính tổng độ dài tên
        int totalLength = names.stream()
                .collect(summingInt(String::length));
        System.out.println("summingInt(): " + totalLength);

        // ✅ Tìm tên dài nhất (sử dụng reducing)
        Optional<String> longestName = names.stream()
                .collect(reducing((s1, s2) -> s1.length() >= s2.length() ? s1 : s2));
        System.out.println("reducing(): " + longestName.orElse(""));

        // ✅ Collect thành Map với key là ký tự đầu, value là tên (có thể gây lỗi nếu trùng key)
        try {
            Map<Character, String> mapKeyFirstChar = names.stream()
                    .collect(toMap(name -> name.charAt(0), Function.identity()));
            System.out.println("toMap(): " + mapKeyFirstChar);
        } catch (IllegalStateException e) {
            System.out.println("toMap(): Lỗi do trùng key");
        }

        // ✅ Sử dụng toMap với merge function để xử lý trùng key
        Map<Character, String> mapMerge = names.stream()
                .collect(toMap(name -> name.charAt(0),
                        Function.identity(),
                        (existing, replacement) -> existing + ", " + replacement));
        System.out.println("toMap() + merge: " + mapMerge);

        // ✅ GroupingBy: nhóm tên theo ký tự đầu tiên
        Map<Character, List<String>> grouped = names.stream()
                .collect(groupingBy(name -> name.charAt(0)));
        System.out.println("groupingBy(): " + grouped);

        // ✅ PartitioningBy: phân chia theo điều kiện (tên dài > 4 ký tự hay không)
        Map<Boolean, List<String>> partitioned = names.stream()
                .collect(partitioningBy(name -> name.length() > 4));
        System.out.println("partitioningBy(): " + partitioned);

        // ✅ mapping(): dùng bên trong groupingBy để biến đổi giá trị nhóm
        Map<Character, List<Integer>> groupedLengths = names.stream()
                .collect(groupingBy(name -> name.charAt(0),
                        mapping(String::length, toList())));
        System.out.println("groupingBy + mapping(): " + groupedLengths);

        // ✅ summarizing: trả về IntSummaryStatistics (max, min, avg, count, sum) cho tên độ dài
        IntSummaryStatistics stats = names.stream()
                .collect(summarizingInt(String::length));
        System.out.println("summarizingInt(): " + stats);
    }
}


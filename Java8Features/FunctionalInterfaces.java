package Java8Features;

import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        // ✅ Function: nhận 1 giá trị kiểu T, trả về giá trị kiểu R
        // Thường dùng để biến đổi dữ liệu (ví dụ: Integer -> String).
        Function<Integer, String> intToString = n -> "Số: " + n;
        System.out.println(intToString.apply(5)); // apply(): thực thi function

        // Sử dụng andThen: sau khi intToString chạy xong, tiếp tục thực hiện hàm khác
        Function<Integer, String> intToStringThenExcited = intToString.andThen(s -> s + "!!!");
        System.out.println(intToStringThenExcited.apply(7)); // (7 -> "Số: 7" -> "Số: 7!!!")

        // Sử dụng compose: thực hiện hàm trước rồi mới đến intToString
        Function<Double, Integer> doubleToInt = d -> (int) Math.round(d);
        Function<Double, String> doubleToString = intToString.compose(doubleToInt);
        System.out.println(doubleToString.apply(6.8)); // (6.8 -> 7 -> "Số: 7")

        // ✅ BiFunction: nhận 2 giá trị (T, U), trả về 1 giá trị R
        // Dùng khi cần xử lý 2 giá trị đầu vào cùng lúc.
        BiFunction<Integer, Integer, String> addToString = (a, b) -> "Tổng: " + (a + b);
        System.out.println(addToString.apply(3, 4)); // apply(): tính tổng rồi trả chuỗi

        // ✅ Predicate: nhận 1 giá trị, trả về boolean (true/false)
        // Thường dùng để kiểm tra điều kiện, lọc dữ liệu.
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("8 chẵn? " + isEven.test(8)); // test(): kiểm tra điều kiện
        System.out.println("5 chẵn? " + isEven.test(5));

        // and(): kết hợp 2 Predicate, phải thỏa mãn cả 2 điều kiện
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> isPositiveEven = isEven.and(isPositive);
        System.out.println("4 chẵn & dương? " + isPositiveEven.test(4)); // true
        System.out.println("-2 chẵn & dương? " + isPositiveEven.test(-2)); // false

        // or(): chỉ cần 1 điều kiện đúng
        Predicate<Integer> isNegative = n -> n < 0;
        Predicate<Integer> isEvenOrNegative = isEven.or(isNegative);
        System.out.println("-3 chẵn hoặc âm? " + isEvenOrNegative.test(-3)); // true
        System.out.println("7 chẵn hoặc âm? " + isEvenOrNegative.test(7));   // false

        // negate(): phủ định kết quả Predicate
        Predicate<Integer> isOdd = isEven.negate();
        System.out.println("3 lẻ? " + isOdd.test(3)); // true

        // ✅ BiPredicate: nhận 2 giá trị (T, U), trả về boolean
        // Dùng để kiểm tra điều kiện với 2 đầu vào cùng lúc.
        BiPredicate<String, Integer> hasLength = (s, len) -> s.length() == len;
        System.out.println("Hello dài 5? " + hasLength.test("Hello", 5));

        // ✅ Consumer: nhận 1 giá trị, thực hiện hành động, KHÔNG trả kết quả
        // Thường dùng cho in/log/ghi file...
        Consumer<String> printUpper = s -> System.out.println("In: " + s.toUpperCase());
        printUpper.accept("hello lambda"); // accept(): thực thi consumer

        // ✅ BiConsumer: giống Consumer nhưng nhận 2 giá trị, không trả kết quả
        // Dùng khi muốn xử lý 2 giá trị cùng lúc (in key-value, vv).
        BiConsumer<String, Integer> printKeyValue = (k, v) -> System.out.println("Key: " + k + ", Value: " + v);
        printKeyValue.accept("Age", 25);

        // ✅ Supplier: không nhận giá trị nào, trả về 1 giá trị T
        // Thường dùng để cung cấp dữ liệu (ví dụ: tạo số random, lấy từ cấu hình...).
        Supplier<Integer> randomSupplier = () -> (int) (Math.random() * 100 + 1);
        System.out.println("Random: " + randomSupplier.get()); // get(): trả giá trị từ supplier

        // ✅ UnaryOperator: giống Function<T, T>, nhận 1 giá trị, trả về cùng kiểu
        // Dùng khi biến đổi giá trị mà không đổi kiểu.
        UnaryOperator<String> addExclamation = s -> s + "!";
        System.out.println(addExclamation.apply("Wow")); // apply(): thực thi unary

        // ✅ BinaryOperator: giống BiFunction<T, T, T>, nhận 2 giá trị cùng kiểu, trả về cùng kiểu
        // Dùng cho phép toán giữa 2 giá trị cùng loại (tìm max, cộng, nhân...).
        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;
        System.out.println("Max(10, 20): " + max.apply(10, 20));

        // andThen() trong UnaryOperator: kết hợp nhiều bước xử lý liên tiếp
        UnaryOperator<String> toUpper = String::toUpperCase;
// ✅ Đây là một UnaryOperator nhận vào một String, trả về String đã viết hoa.
// Sử dụng method reference String::toUpperCase tương đương với lambda s -> s.toUpperCase()

        Function<String, String> shout = addExclamation.andThen(toUpper);
// ✅ addExclamation là UnaryOperator<String> trước đó (s -> s + "!").
// ✅ addExclamation.andThen(toUpper) nghĩa là:
//   1️⃣ Đầu tiên thực thi addExclamation: thêm dấu "!" vào cuối chuỗi.
//   2️⃣ Sau đó thực thi toUpper: viết hoa chuỗi kết quả.
// 👉 Ví dụ: "amazing" -> "amazing!" -> "AMAZING!"

        System.out.println(shout.apply("amazing")); // amazing -> amazing! -> AMAZING!
    }
}

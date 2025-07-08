package Java8Features;

import java.util.Optional;

public class OptionalEx {
    public static void main(String[] args) {
        // 1️⃣ Tạo Optional chứa giá trị chắc chắn không null
        Optional<String> opt1 = Optional.of("Hello, Optional!");
        // Sử dụng get() để lấy giá trị bên trong (chỉ nên dùng khi chắc chắn không empty)
        System.out.println("opt1.get(): " + opt1.get());

        // 2️⃣ Tạo Optional với giá trị có thể null
        String maybeNull = null;
        Optional<String> opt2 = Optional.ofNullable(maybeNull);
        // isPresent(): kiểm tra xem có giá trị hay không
        System.out.println("opt2.isPresent(): " + opt2.isPresent()); // false

        // 3️⃣ empty(): Optional rỗng
        Optional<String> opt3 = Optional.empty();
        System.out.println("opt3.isEmpty(): " + opt3.isEmpty()); // true

        // 4️⃣ orElse(): trả về giá trị bên trong nếu có, nếu không trả giá trị mặc định
        String result1 = opt2.orElse("Giá trị mặc định");
        System.out.println("opt2.orElse(): " + result1);

        // 5️⃣ orElseGet(): dtương tự orElse nhưng giá trị mặc định được tạo ra bởi Supplier (lười khởi tạo)
        String result2 = opt2.orElseGet(() -> "Giá trị từ Supplier");
        System.out.println("opt2.orElseGet(): " + result2);

        // 6️⃣ orElseThrow(): ném exception nếu không có giá trị
        try {
            opt2.orElseThrow(() -> new IllegalArgumentException("Không có giá trị!"));
        } catch (Exception e) {
            System.out.println("opt2.orElseThrow(): " + e.getMessage());
        }

        // 7️⃣ ifPresent(): thực hiện hành động nếu có giá trị
        opt1.ifPresent(s -> System.out.println("opt1.ifPresent(): " + s));

        // 8️⃣ ifPresentOrElse(): (Java 9+) thực hiện hành động nếu có giá trị, nếu không thì làm hành động khác
        opt2.ifPresentOrElse(
                s -> System.out.println("opt2.ifPresentOrElse(): Có giá trị: " + s),
                () -> System.out.println("opt2.ifPresentOrElse(): Không có giá trị.")
        );

        // 9️⃣ map(): biến đổi giá trị bên trong Optional
        Optional<Integer> optLength = opt1.map(String::length);
        System.out.println("opt1.map(): Độ dài chuỗi: " + optLength.get());

        // 10️⃣ flatMap(): tương tự map nhưng tránh Optional lồng nhau
        Optional<String> optFlat = opt1.flatMap(s -> Optional.of(s.toUpperCase()));
        System.out.println("opt1.flatMap(): " + optFlat.get());

        // 11️⃣ filter(): lọc giá trị bên trong, nếu không thỏa mãn điều kiện sẽ trả Optional.empty()
        Optional<String> optFilter = opt1.filter(s -> s.startsWith("Hello"));
        System.out.println("opt1.filter(): isPresent=" + optFilter.isPresent()); // true

        Optional<String> optFilterFail = opt1.filter(s -> s.startsWith("Bye"));
        System.out.println("opt1.filter() không khớp: isPresent=" + optFilterFail.isPresent()); // false

        // 12️⃣ setEmptyValue() không tồn tại trong Optional - đó là của StringJoiner.
        // Nhiều người hay nhầm lẫn giữa Optional và StringJoiner!

        // 13️⃣ equals(), hashCode(), toString()
        Optional<String> anotherOpt = Optional.of("Hello, Optional!");
        System.out.println("opt1.equals(anotherOpt): " + opt1.equals(anotherOpt)); // true
        System.out.println("opt1.hashCode(): " + opt1.hashCode());
        System.out.println("opt1.toString(): " + opt1.toString());
    }
}


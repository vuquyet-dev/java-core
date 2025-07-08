package Java8Features;
import java.util.function.Function;
import java.util.function.UnaryOperator;
public class MethodReferences {
    public static void main(String[] args) {
        // ✅ Method reference: String::trim (xóa khoảng trắng đầu/cuối)
        Function<String, String> trimFunc = String::trim;
        System.out.println("[" + trimFunc.apply("  Hello  ") + "]");
        // apply(): chạy trimFunc -> kết quả: "Hello"

        // ✅ Method reference: String::toUpperCase
        UnaryOperator<String> upperFunc = String::toUpperCase;
        System.out.println(upperFunc.apply("hello"));
        // apply(): chạy upperFunc -> "HELLO"

        // ✅ andThen(): chạy trim trước, rồi viết hoa
        Function<String, String> trimThenUpper = trimFunc.andThen(String::toUpperCase);
        System.out.println("[" + trimThenUpper.apply("   lambda   ") + "]");
        // "   lambda   " -> trim -> "lambda" -> toUpperCase -> "LAMBDA"

        // ✅ compose(): chạy viết hoa trước, rồi trim
        Function<String, String> upperThenTrim = trimFunc.compose(String::toUpperCase);
        System.out.println("[" + upperThenTrim.apply("   java   ") + "]");
        // "   java   " -> toUpperCase -> "   JAVA   " -> trim -> "JAVA"

        // ✅ andThen với UnaryOperator
        UnaryOperator<String> shout = s -> upperFunc.andThen(str -> str + "!").apply(s);
        System.out.println(shout.apply("amazing"));
        // "amazing" -> toUpperCase -> "AMAZING" -> + "!" -> "AMAZING!"

        // ✅ compose với UnaryOperator
        UnaryOperator<String> shout2 = upperFunc;
        System.out.println(shout2.apply("wow"));
        // "wow" -> + "!" -> "wow!" -> toUpperCase -> "WOW!"
    }
}

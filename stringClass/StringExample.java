package stringClass;
public class StringExample {
    public static void main(String[] args) {

        String text = "My name í vu van quyet, i am 22 years old";
        System.out.println("Length: " + text.length());
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        String[] a = text.trim().split("\\s+");
        System.out.println("dem so tu: " + a.length);
        StringBuilder sb = new StringBuilder(text);
        System.out.println(sb.reverse().toString());
        if(text.contains("name"))
        {
            System.out.println("true");
        }else{
            System.out.println(false);
        }
        System.out.println(text.replace("name", "ten"));
        System.out.println(text.compareTo("My name í vu van quyet, i am 22 years old"));

    }
}

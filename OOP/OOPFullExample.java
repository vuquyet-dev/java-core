package OOP;


/*
🎯 Giới thiệu OOP (Object-Oriented Programming):
- OOP là lập trình hướng đối tượng, tập trung vào mô hình hóa các thực thể trong thực tế thành "đối tượng" (object) trong lập trình.
- Một đối tượng có:
  + Thuộc tính (attributes / fields) → mô tả trạng thái.
  + Hành vi (behavior / methods) → mô tả hành động.
- OOP có 4 tính chất chính:
  ✅ Tính đóng gói (Encapsulation)
  ✅ Tính kế thừa (Inheritance)
  ✅ Tính đa hình (Polymorphism)
  ✅ Tính trừu tượng (Abstraction)

📌 Trong bài mẫu, chúng ta minh họa cả 4 tính chất:
1️⃣ Đóng gói: Sử dụng private cho thuộc tính + getter/setter để truy cập.
2️⃣ Kế thừa: Class Student kế thừa Person.
3️⃣ Đa hình:
    🔹 Nạp chồng phương thức (Overloading): nhiều phương thức cùng tên khác tham số.
    🔹 Ghi đè phương thức (Overriding): Student ghi đè phương thức của Person.
4️⃣ Trừu tượng: Dùng abstract class (hoặc interface nếu cần) để định nghĩa khung cho lớp con (trong bài này là Person -> Student).

Các thành phần trong bài
        - Class
        - Constructor
        - Tính chất hướng đối tượng: kế thừa, đa hình, trừu tượng, bao đóng
        - Overloading, Overiding
        - Từ khóa static, this, super, final
        - Access modifier
        - abstract và interface
        - toán tử instanceof
        - Static vs Dynamic binding
        - Inner, Nested and Anonymous Class
 */

// Lớp Animal là abstract, đại diện cho các loài động vật - thể hiện tính trừu tượng
abstract class Animal {
    protected String name; // tên động vật, protected cho phép truy cập từ lớp con
    protected int age;     // tuổi
    private final String type = "Động vật"; // final: không thể thay đổi giá trị sau khởi tạo

    // Constructor khởi tạo Animal với tên và tuổi
    public Animal(String name, int age) {
        this.name = name;   // từ khóa this tham chiếu tới biến của object
        this.age = age;
    }

    // Phương thức trừu tượng bắt buộc lớp con phải override
    public abstract void makeSound();

    // Phương thức thông thường: tất cả Animal đều có thể ngủ
    public void sleep() {
        System.out.println(name + " đang ngủ...");
    }

    // Phương thức static: gọi qua class Animal, không cần tạo đối tượng
    public static void info() {
        System.out.println("Đây là hệ thống quản lý động vật!");
    }

    // Phương thức final: không cho phép lớp con override
    public final void showType() {
        System.out.println(name + " là " + type);
    }
}

// Interface: định nghĩa hành vi play cho các lớp cài đặt
interface Playable {
    void play(); // phương thức trừu tượng mặc định trong interface
}

// Lớp Dog kế thừa Animal & cài đặt Playable → tính kế thừa & đa hình
class Dog extends Animal implements Playable {
    private String breed; // giống chó

    // Constructor Dog, dùng super() gọi constructor Animal
    public Dog(String name, int age, String breed) {
        super(name, age); // gọi constructor cha Animal
        this.breed = breed;
    }

    @Override // Ghi đè phương thức trừu tượng makeSound → Overriding
    public void makeSound() {
        System.out.println(name + " sủa: Gâu gâu!");
    }

    // Overloading: phương thức cùng tên eat nhưng khác tham số
    public void eat() {
        System.out.println(name + " ăn thức ăn cho chó.");
    }

    public void eat(String food) {
        System.out.println(name + " ăn " + food + ".");
    }

    @Override // cài đặt phương thức trong interface Playable
    public void play() {
        System.out.println(name + " đang chơi ném bóng!");
    }
}

// Lớp Owner mô tả chủ nuôi
class Owner {
    String ownerName;

    public Owner(String name) {
        this.ownerName = name;
    }

    // Inner class: lớp bên trong lớp Owner
    class PetHouse {
        void showHouse() {
            System.out.println(ownerName + " có một chuồng thú cưng.");
        }
    }

    // Static nested class: lớp tĩnh bên trong Owner
    static class OwnerInfo {
        static void greet() {
            System.out.println("Xin chào từ OwnerInfo!");
        }
    }
}

// Main class chứa phương thức main để chạy chương trình
public class OOPFullExample {
    public static void main(String[] args) {
        // Gọi phương thức static → static binding (xảy ra ở compile time)
        Animal.info();

        // Tạo đối tượng Dog nhưng tham chiếu Animal → dynamic binding (runtime)
        Animal myDog = new Dog("Kiki", 3, "Husky");
        myDog.makeSound();   // dynamic binding: gọi makeSound của Dog
        myDog.sleep();       // kế thừa phương thức sleep từ Animal
        myDog.showType();    // phương thức final từ Animal, không thể ghi đè

        // Ép kiểu Animal → Dog để gọi phương thức eat() riêng của Dog
        if (myDog instanceof Dog) { // toán tử instanceof kiểm tra kiểu runtime
            Dog dog = (Dog) myDog;  // ép kiểu tường minh
            dog.eat();              // overloading không tham số
            dog.eat("xương gà");    // overloading có tham số
            dog.play();             // phương thức từ interface Playable
        }

        // Inner class: cần object owner để tạo
        Owner owner = new Owner("Nam");
        Owner.PetHouse house = owner.new PetHouse(); // inner class instance
        house.showHouse();

        // Static nested class: không cần instance Owner
        Owner.OwnerInfo.greet();

        // Anonymous class: Animal không thể tạo instance trực tiếp (vì abstract),
        // nhưng có thể khởi tạo qua anonymous class override makeSound
        Animal cat = new Animal("Mimi", 2) {
            @Override
            public void makeSound() {
                System.out.println(name + " kêu: Meo meo!");
            }

        };
        cat.makeSound(); // gọi phương thức đã override trong anonymous class

    }
}

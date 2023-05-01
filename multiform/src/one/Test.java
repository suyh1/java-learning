package one;

public class Test {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.eat();
        System.out.println(a.num);
        // 报错：a.num2.sout
        a = new Dog();
        a.eat();

    }
}

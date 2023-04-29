package one;

public class JiduDog extends Dog implements JiDuInter{

    public JiduDog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("吃军粮");
    }

    @Override
    public void Jidu() {
        System.out.println("缉毒犬用气味识别");
    }
}

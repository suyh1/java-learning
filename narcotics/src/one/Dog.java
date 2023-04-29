package one;

public abstract class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void haul(){
        System.out.println("汪汪叫");
    }

    public abstract void eat();
}

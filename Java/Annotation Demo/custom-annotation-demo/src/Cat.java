import custom_annotation.RunImmediately;
import custom_annotation.VeryImp;

@VeryImp
public class Cat {
    private String name;

    Cat() {

    }

    Cat(String name) {
        this.name = name;
    }


    @RunImmediately(times = 3)
    public void meow() {
        System.out.println("Meow");
    }

    public void eat() {
        System.out.println("Munch");
    }
}

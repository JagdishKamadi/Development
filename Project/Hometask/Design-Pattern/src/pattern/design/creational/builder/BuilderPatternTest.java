package pattern.design.creational.builder;
public class BuilderPatternTest {
    public static void main(String[] args) {
        Laptop laptop = new LaptopBuilder("4gb","1024gb","2.3gh").build();
        System.out.println(laptop);

        Laptop laptop1 = new LaptopBuilder("4gb","1024gb","2.3gh").setIsBlutoothEnabled(true).setIsGraphicEnabled(true).build();
        System.out.println(laptop1);

        Laptop laptop2 = new LaptopBuilder("4gb","1024gb","2.3gh").setIsBlutoothEnabled(true).build();
        System.out.println(laptop2);
    }
}

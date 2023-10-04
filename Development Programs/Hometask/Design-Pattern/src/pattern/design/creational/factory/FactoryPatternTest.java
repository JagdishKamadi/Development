package pattern.design.creational.factory;

public class FactoryPatternTest {
    public static void main(String[] args) {

        OperatingSystemFactory operatingSystemFactory1 = new OperatingSystemFactory();
        OS os1 = operatingSystemFactory1.getInstance("Secure");
        // it should print the object of IOS class
        System.out.println(os1);
        os1.spec();

        // same for all
        OperatingSystemFactory operatingSystemfactory2 = new OperatingSystemFactory();
        OS os2 = operatingSystemfactory2.getInstance("Easy to use");
        // it should print the object of windows class
        System.out.println("\n"+os2);
        os2.spec();

       OperatingSystemFactory operatingSystemFactory3 = new OperatingSystemFactory();
       OS os3 = operatingSystemFactory3.getInstance("Powerful");
       System.out.println("\n"+os3);
       os3.spec();
    }
}

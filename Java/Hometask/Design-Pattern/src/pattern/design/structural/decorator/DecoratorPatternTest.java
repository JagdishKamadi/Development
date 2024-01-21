package pattern.design.structural.decorator;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Dress dress1 = new SportyDress(new BasicDress());
        dress1.assemble();
        System.out.println();

        Dress dress2 = new CasualDress(new BasicDress());
        dress2.assemble();
        System.out.println();

        Dress dress3 = new FancyDress(new BasicDress());
        dress3.assemble();
        System.out.println();

        Dress dress4 = new FancyDress(new CasualDress(new BasicDress()));
        dress4.assemble();
        System.out.println();

        Dress dress5 = new SportyDress(new FancyDress(new CasualDress(new BasicDress())));
        dress5.assemble();
    }
}

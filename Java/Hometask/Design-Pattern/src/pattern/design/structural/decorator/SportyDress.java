package pattern.design.structural.decorator;

public class SportyDress extends DressDecorator{
    SportyDress(Dress dress)
    {
        super(dress);
    }

    public void assemble()
    {
        super.assemble();
        System.out.println("Adding Sporty Dress Features");
    }
}

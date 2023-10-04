package pattern.design.structural.decorator;

public class DressDecorator implements Dress {
    protected Dress dress;

    DressDecorator(Dress dress)
    {
        this.dress = dress;
    }

    public void assemble()
    {
        this.dress.assemble();
    }
}

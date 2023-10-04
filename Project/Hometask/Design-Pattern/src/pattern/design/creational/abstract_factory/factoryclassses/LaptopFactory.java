package pattern.design.creational.abstract_factory.factoryclassses;
import pattern.design.creational.abstract_factory.classes.Computer;
import pattern.design.creational.abstract_factory.Laptop;

public class LaptopFactory implements AbstractComputerFactory{
    private final String ram;
    private final String hdd;
    private final  String cpu;

    public LaptopFactory(String ram,String hdd,String cpu)
    {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    public Computer createComputer()
    {
        return new Laptop(ram,hdd,cpu);
    }

}

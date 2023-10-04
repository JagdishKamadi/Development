package pattern.design.creational.abstract_factory.factoryclassses;
import pattern.design.creational.abstract_factory.classes.Computer;
import pattern.design.creational.abstract_factory.PC;

public class PCFactory implements AbstractComputerFactory{
    final private String ram;
    final private String hdd;
    final private String cpu;

    public PCFactory(String ram, String hdd, String cpu)
    {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    public Computer createComputer()
    {
        return new PC(ram,hdd,cpu);
    }
}

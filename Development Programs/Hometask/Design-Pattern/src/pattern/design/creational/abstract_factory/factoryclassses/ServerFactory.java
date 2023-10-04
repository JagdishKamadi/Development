package pattern.design.creational.abstract_factory.factoryclassses;
import pattern.design.creational.abstract_factory.classes.Computer;
import pattern.design.creational.abstract_factory.Server;

public class ServerFactory implements AbstractComputerFactory {
    private final String ram;
    private final String hdd;
    private final  String cpu;

    public ServerFactory(String ram, String hdd, String cpu)
    {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    public Computer createComputer()
    {
        return new Server(ram,hdd,cpu);
    }
}

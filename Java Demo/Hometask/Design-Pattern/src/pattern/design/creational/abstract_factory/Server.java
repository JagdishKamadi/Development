package pattern.design.creational.abstract_factory;

import pattern.design.creational.abstract_factory.classes.Computer;

public class Server implements Computer {
    private final String ram;
    private final String hdd;
    private final  String cpu;

    public Server(String ram,String hdd,String cpu)
    {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    public String getRam()
    {
        return this.ram;
    }

    public String getHdd()
    {
        return this.hdd;
    }

    public String getCpu()
    {
        return this.cpu;
    }

    @Override
    public String toString() {
        return "Server{" +
                "ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", cpu='" + cpu + '\'' +
                '}';
    }
}

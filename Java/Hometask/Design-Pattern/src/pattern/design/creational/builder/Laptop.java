package pattern.design.creational.builder;
public class Laptop {

    // required parameter
    private String ram;
    private String hdd;
    private String cpu;

    // optional parameter
    private boolean isGraphicEnabled;
    private boolean isBlutoothEnabled;

    public Laptop(String ram, String hdd, String cpu, boolean isGraphicEnabled, boolean isBlutoothEnabled) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
        this.isGraphicEnabled = isGraphicEnabled;
        this.isBlutoothEnabled = isBlutoothEnabled;
    }

    // to build the object of laptop
    protected Laptop(LaptopBuilder builder)
    {
        this.ram = builder.getRam();
        this.hdd = builder.getHdd();
        this.cpu = builder.getCpu();
        this.isBlutoothEnabled = builder.isBlutoothEnabled();
        this.isGraphicEnabled = builder.isGraphicEnabled();
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", cpu='" + cpu + '\'' +
                ", isGraphicEnabled=" + isGraphicEnabled +
                ", isBlutoothEnabled=" + isBlutoothEnabled +
                '}';
    }
}

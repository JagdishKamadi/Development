package pattern.design.creational.builder;
public class LaptopBuilder {
    // required parameter
    private String ram;
    private String hdd;
    private String cpu;

    // optional parameter
    private boolean isGraphicEnabled;
    private boolean isBlutoothEnabled;

    public LaptopBuilder(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    public LaptopBuilder setIsGraphicEnabled(boolean value)
    {
        this.isGraphicEnabled = value;

        return this;
    }

    public LaptopBuilder setIsBlutoothEnabled(boolean value)
    {
        this.isBlutoothEnabled = value;
        return this;
    }

    public String getRam() {
        return ram;
    }

    public String getHdd() {
        return hdd;
    }

    public String getCpu() {
        return cpu;
    }

    public boolean isGraphicEnabled() {
        return isGraphicEnabled;
    }

    public boolean isBlutoothEnabled() {
        return isBlutoothEnabled;
    }

    // to return the object of laptop class
    public Laptop build()
    {
        // we need to pass the LaptopBuilder object here
        return new Laptop(this);
    }
}

// Demo of Enum Constructors and Fields

public enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6);

    private Double mass = null; // in kilograms
    private Double radius = null; // in kilometers

    Planet(Double mass, Double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public Double getMass() {
        return mass;
    }

    public Double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "mass=" + mass +
                ", radius=" + radius +
                '}';
    }
}

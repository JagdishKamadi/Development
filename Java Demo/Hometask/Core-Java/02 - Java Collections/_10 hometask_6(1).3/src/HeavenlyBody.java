import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

/*
        HeavenlyBody h1 = new HeavenlyBody();
        HeavenlyBody h2 = new HeavenlyBody();
        h1.equals(h2);
 */
    public boolean equals(Object obj)
    {
       if(this == obj)
           return true;

        if(obj==null || this.getClass()!=obj.getClass())
            return false;

        HeavenlyBody heavenlyBody = (HeavenlyBody)obj;

        if(this.hashCode()==heavenlyBody.hashCode())
        {

            return this.name == heavenlyBody.name   &&
                    this.orbitalPeriod == heavenlyBody.orbitalPeriod;
        }

        return false;
    }

    public int hashCode()
    {
        System.out.println("Hashcode Called");

        return this.name.length() % 10;
    }
}

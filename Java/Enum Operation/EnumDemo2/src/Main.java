public class Main {
    public static void main(String[] args) {

        Planet earth = Planet.EARTH;

        System.out.println("Mass\t" + earth.getMass());
        System.out.println("Radius\t" + earth.getRadius());
        System.out.println(earth);

        for (Planet planet : Planet.values()) {
            System.out.println(planet);
        }
    }
}
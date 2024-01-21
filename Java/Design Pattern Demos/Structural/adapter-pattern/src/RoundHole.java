/**
 * RoundHoles are compatible with RoundPegs.
 */
public class RoundHole {
    private Double radius;

    public RoundHole(Double radius) {
        this.radius = radius;
    }

    public Double getRadius() {
        return this.radius;
    }

    public boolean isFit(RoundPeg peg) {
        return this.getRadius() >= peg.getRadius();
    }
}

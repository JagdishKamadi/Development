/**
 * SquarePegs are not compatible with RoundHoles (they were implemented by
 * previous development team). But we have to integrate them into our program.
 */
public class SquarePeg {
    private Double width;

    public SquarePeg(Double width) {
        this.width = width;
    }

    public Double getWidth() {
        return width;
    }

    public Double getSquare() {
        return Math.pow(this.getWidth(), 2);
    }
}

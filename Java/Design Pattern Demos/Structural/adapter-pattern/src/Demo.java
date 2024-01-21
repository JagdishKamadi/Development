import java.io.PrintStream;

public class Demo {

    private static final PrintStream OP = System.out;

    public static void main(String[] args) {


        //Round fits round, no surprise.
        RoundHole roundHole = new RoundHole(5D);
        RoundPeg roundPeg = new RoundPeg(5D);

        if (roundHole.isFit(roundPeg)) {
            OP.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2D);
        SquarePeg largeSqPeg = new SquarePeg(20D);

        // Adapter solves the problem.
        SquarePegAdapter smallPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largePegAdapter = new SquarePegAdapter(largeSqPeg);
        if (roundHole.isFit(smallPegAdapter)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!roundHole.isFit(largePegAdapter)) {
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }

    }
}
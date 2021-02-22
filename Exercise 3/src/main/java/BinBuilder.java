
/**
 * Represents the Roulette wheel and used for computing the winning bin each round.
 *
 */
public class BinBuilder {

    /**
     * Generates the bins of a given wheel with the relevant outcomes.
     * @param wheel is the wheel for which the bins are generated
     */

    public static void buildBins(Wheel wheel) {
        buildStraight(wheel);
        buildSplit(wheel);
        buildStreet(wheel);
    }

    private static void buildStraight(Wheel wheel) {
        Outcome o;

        for (int i = 1; i <= 36; i++) {
            wheel.addOutcome(i,new Outcome(Integer.toString(i), 35));
        }
        wheel.addOutcome(0,new Outcome("0", 35));
        wheel.addOutcome(37,new Outcome("00", 35));
    }

    private static void buildSplit(Wheel wheel) {
        int n;
        Outcome outcome;
        // Horizontal splits:
        for (int r = 0; r < 12; r++) {
            // First column number:
            n = 3 * r + 1;
            // Column 1-2 split
            outcome = new Outcome("" + n + "," + (n + 1), 17);
            wheel.addOutcome(n, outcome);
            wheel.addOutcome(n + 1, outcome);
            // Second column number:
            n = 3 * r + 2;
            // Column 2-3 split
            outcome = new Outcome("" + n + "," + (n + 1), 17);
            wheel.addOutcome(n, outcome);
            wheel.addOutcome(n + 1, outcome);
        }
        // Vertical splits:
        for (int i = 1; i < 33; i++) {
            outcome = new Outcome("" + i + "," + (i + 3), 17);
            wheel.addOutcome(i, outcome);
            wheel.addOutcome(i + 3, outcome);
        }
    }

    private static void buildStreet(Wheel wheel) {
        int n;
        Outcome outcome;
        for (int r = 0; r < 12; r++) {
            n = 3 * r + 1;
            outcome = new Outcome("" + n + "," + (n + 1) + "," + (n + 2), 11);
            wheel.addOutcome(n, outcome);
            wheel.addOutcome(n + 1, outcome);
            wheel.addOutcome(n + 2, outcome);
        }
    }
}

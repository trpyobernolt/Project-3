public class Wheel {
    private static Bin[] bins = new Bin[186];
    private static Bin[] oneOutcome = new Bin[110];
    private static int curr;
    private static int check;

    public Wheel() {
    }

    public void addOutcome(int something, Outcome o) {
        //adds an outcome to the bins. If not in the non-repetitive array, it adds it
        Bin outcome = new Bin(something, o);
        this.bins[curr] = outcome;
        if (curr == 0) {
            oneOutcome[check] = outcome;
            check++;
        }
        boolean isListed = false;
        for (int i = 0; i < check; i++) {
            if (compareOutcomes(outcome, oneOutcome[i])) {
                isListed = true;
            }
        }
        if (isListed == false) {
            oneOutcome[check] = outcome;
            check++;
        }
        curr++;
    }

    public boolean compareOutcomes(Bin oc1, Bin oc2) {
        // compare two outcomes to see if they are the same
        boolean sameBin = false;
        boolean samePayout = false;
        if (oc1.getPlace() == oc2.getPlace()) {
            sameBin = true;
        }
        if (oc1.getOutcome().getPayout() == oc2.getOutcome().getPayout()) {
            samePayout = true;
        }
        return (sameBin && samePayout);
    }

    public static Bin[] getBins() {
        return bins;
    }

    public static Bin[] getOneOutcome() {
        return oneOutcome;
    }

    public static void main(String[] args) {
        Wheel wheel = new Wheel();
        BinBuilder.buildBins(wheel);
        for(int i = 0; i < curr; i++) {
            System.out.println(bins[i].getOutcome().payout + ", " + bins[i].getOutcome().getBin());
        }
        System.out.println(check);
        for(int i = 0; i < check; i++) {
            System.out.println(oneOutcome[i].getOutcome().getPayout() + ", " + oneOutcome[i].getOutcome().getBin());
        }
        System.out.println(curr);
        System.out.println(bins.length);
        System.out.println(check);
    }
}

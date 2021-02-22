public class Bin {
    private int place;
    private Outcome outcome;

    Bin(int place, Outcome outcome) {
        this.place = place;
        this.outcome = outcome;
    }

    public int getPlace() {
        return place;
    }

    public Outcome getOutcome() {
        return outcome;
    }
}

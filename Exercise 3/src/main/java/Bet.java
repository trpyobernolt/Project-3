public class Bet {
    Outcome outcome;
    int bet;

    public Bet(int bet, Outcome outcome) {
        this.bet = bet;
        this.outcome = outcome;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public int getBet() {
        return bet;
    }
}

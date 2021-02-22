public class Table {
    Bet[] bets = new Bet[1];

    Table() {
    }

    public void placeBet(Bet bet){
        bets[0] = bet;
    }

    public Bet[] getBets() {
        return bets;
    }
}

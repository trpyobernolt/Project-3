import java.util.Random;

public class Player {
    private int initialBank;
    private int bank;
    private Table table;
    private Bin[] possibleBets;

    public Player(int ini, Table table, Bin[] possibleBets) {
        this.bank = ini;
        this.initialBank = ini;
        this.table = table;
        this.possibleBets = possibleBets;
    }

    public boolean stillPlaying(){
        //returns true if a player can place another bet
        return this.bank > 15;
    }

    public void placeBets(int amount) {
        //places bets and decreases bet from bank
        Random rand = new Random();
        int chosen = rand.nextInt(possibleBets.length);
        Bin bin = possibleBets[chosen];
        String place = String.valueOf(bin.getPlace());
        Bet bet = new Bet(amount, bin.getOutcome());
        table.placeBet(bet);
        this.bank -= amount;
    }
    public void increaseBank(int amount) {
        this.bank += amount;
    }

    public int getBank() {
        return bank;
    }

    public void reset() {
        bank = initialBank;
    }
}

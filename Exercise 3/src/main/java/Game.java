import java.util.Random;

public class Game {
    private Wheel wheel;
    // generate outcomes of spin
    private Player player;
    private Table table;
    private int initialStake = 1000;
    private int betAmount = 15;

    public Game() {
        this.wheel = new Wheel();
        BinBuilder.buildBins(wheel);
        this.table = new Table();
        this.player = new Player(initialStake, table, wheel.getOneOutcome());
    }

    public Table getTable() {
        return table;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public Bin[] getPossibleBets(){
        return this.wheel.getOneOutcome();
    }

    public void cycle(Player player) {
        //Runs one round of game
        player.placeBets(betAmount);
        Bet[] bets = table.getBets();
        Bin[] results = wheel.getBins();
        Random rand = new Random();
        Outcome chosen = results[rand.nextInt(results.length)].getOutcome();
        for(int i = 0; i < bets.length; i++){
            if(bets[i].getOutcome().getBin() == chosen.getBin()) {
                int added = bets[i].getBet() * chosen.getPayout();
                player.increaseBank(added);
            }
        }
    }
}

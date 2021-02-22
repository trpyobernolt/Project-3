import java.util.Random;

public class Simulation {
    private static Game game;
    // roulette and rules of roulette
    // Take a player's bet and wheel outcome to calculate payout based on rules
    private static Player player;
    // Player's bank
    // Player's bet
    // Dictates how player acts
    private int initialBank;
    private int maxStakeRound;
    private int totalRounds;
    private int stakeAtEnd;
    private Statistics stats;

    public static void main(String[] args) {
        game = new Game();
        player = new Player( 1000, game.getTable(), game.getPossibleBets());
        Simulation sim = new Simulation(player, game);
        for(int i = 0; i <= 100; i++) {
            sim.session();
        }
        sim.stats.printData();
    }

    public Simulation(Player player, Game game) {
        this.player = player;
        this.game = game;
        this.stats = new Statistics();
    }

    private void session() {
        ///Runs one session of roulette
        int maxStake = 1000;
        int roundHighestStake = 0;
        int numRounds = 1;
        while(player.stillPlaying() && numRounds < 50) {
            game.cycle(player);
            if(player.getBank() > maxStake) {
                maxStake = player.getBank();
                roundHighestStake = numRounds;
            }
            numRounds++;
        }
        stats.recordData(maxStake, roundHighestStake, numRounds, player.getBank());
        System.out.println("Max Stake is: " + maxStake + " At round: " + roundHighestStake);
        System.out.println("Number of rounds played is: " + numRounds);
        System.out.println("Stake at end of simulation is " + player.getBank());
        System.out.println("\n");
        player.reset();
    }
}

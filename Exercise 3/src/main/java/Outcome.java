public class Outcome {
    String bin = "";
    int payout;
    public Outcome(String bin, int payout) {
        this.bin = bin;
        this.payout = payout;
    }

    public String getBin() {
        return bin;
    }

    public int getPayout() {
        return payout;
    }
}

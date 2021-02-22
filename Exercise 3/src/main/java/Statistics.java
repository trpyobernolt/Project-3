public class Statistics {
    private int[] maxStakes = new int[101];
    private int[] roundMaxStake = new int[101];
    private int[] roundsPlayed = new int[101];
    private int[] stakesAtEnd = new int[101];
    private int simNumber = 0;

    public void recordData(int max, int round, int played, int end) {
        this.maxStakes[simNumber] = max;
        this.roundMaxStake[simNumber] = round;
        this.roundsPlayed[simNumber] = played;
        this.stakesAtEnd[simNumber] = end;
        simNumber++;
    }

    public void printData(){
        System.out.println("Mean of max stakes is: " + getMean(this.maxStakes));
        System.out.println("Median of max stakes is: " + getMedian(this.maxStakes));
        System.out.println("Standard Deviation of max stakes is: " + getSD(this.maxStakes));
        System.out.println("The mean of end stake is " + getMean(this.stakesAtEnd));
        System.out.println("The Median end stake is: " + getMedian(this.stakesAtEnd));
        System.out.println("The Standard Deviation of end stake is: " + getSD(this.stakesAtEnd));
        System.out.println("The mean of rounds played is " + getMean(this.roundsPlayed));
        System.out.println("The Median of rounds played  is: " + getMedian(this.roundsPlayed));
        System.out.println("The Standard Deviation of rounds played is: " + getSD(this.roundsPlayed));
    }

    public int getMedian(int[] arr){
        if(arr.length%2 == 1) {
            return arr[(arr.length+1)/2-1];
        }
        return(arr[arr.length/2-1]+arr[arr.length/2])/2;
    }

    public double getMean(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return (sum / arr.length);
    }

    public double getSD(int[] arr){
        return Math.sqrt(getMean(arr));
    }

    public int[] getMaxStakes() {
        return maxStakes;
    }

    public int[] getRoundMaxStake() {
        return roundMaxStake;
    }

    public int[] getRoundsPlayed() {
        return roundsPlayed;
    }

    public int[] getStakesAtEnd() {
        return stakesAtEnd;
    }
}

package threads;

/**
 * Contains code that represents the counting process.
 * It will keep counting the number of votes each cake design is getting.
 */

public class CountingRunnable implements Runnable {

    private Design d;
    protected boolean doStop = false;

    public CountingRunnable(Design d) {
        this.d = d;
    }

    @Override
    public void run() {
        //Ch03-Step 5 - Surround the code in a while loop

        //Ch03-Step 3 - Pause the thread for 2 seconds
        System.out.println("Design " + d.getName() + " has " + d.getVotes().size() + " votes");
    }
}

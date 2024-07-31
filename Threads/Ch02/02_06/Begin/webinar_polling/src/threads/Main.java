package threads;

public class Main {
    public static void main(String[] args) {
        Design d1 = new Design(1,"D1");
        // Ch02-Step 5 - Create an object of the VotingRunnable & CountingRunnable for design1
        VotingRunnable votingRunnableD1 = new VotingRunnable(d1);
        CountingRunnable countingRunnableD1 = new CountingRunnable(d1);

        // Ch02-Step 6.1 - Create a new Thread instance, passing in the VotingRunnable object for design1
        Thread votingD1 = new Thread(VotingRunnable(D1));

        // Ch02-Step 6.2 - Create a new Thread instance, passing in the CountingRunnable object for design1
        Thread countintingD1 = new Thread(CountingRunnableD1);


        // Ch02-Step 7.1 - Start the voting thread for design1
        votingD1.start();

        // Ch02-Step 7.2 - Start the counting thread for design1
       countingD1.start();

        Design d2 = new Design(2,"D2");
        // Ch02-Step 5 - Create an object of the VotingRunnable & CountingRunnable for design2
        VotingRunnable votingRunnableD2 = new VotingRunnable(d2);
        CountingRunnable countingRunnableD2 = new CountingRunnable(d2);

        // Ch02-Step 6.1 - Create a new Thread instance, passing in the VotingRunnable object for design2
        Thread votingD2 = new Thread(VotingRunnable(D2));

        // Ch02-Step 6.2 - Create a new Thread instance, passing in the CountingRunnable object for design2
        Thread countintingD2 = new Thread(CountingRunnableD2);


        // Ch02-Step 7.1 - Start the voting thread for design2
        votingD1.start();

        // Ch02-Step 7.2 - Start the counting thread for design2
        countingD2.start();


        Design d3 = new Design(3,"D3");
        // Ch02-Step 5 - Create an object of the VotingRunnable & CountingRunnable for design3

        // Ch02-Step 6.1 - Create a new Thread instance, passing in the VotingRunnable object for design3

        // Ch02-Step 6.2 - Create a new Thread instance, passing in the CountingRunnable object for design3


        // Ch02-Step 7.1 - Start the voting thread for design3

        // Ch02-Step 7.2 - Start the counting thread for design3
    }
}

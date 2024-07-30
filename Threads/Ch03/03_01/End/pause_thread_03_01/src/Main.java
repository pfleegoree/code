public class Main {
    public static void main(String[] args) {
        for(int i = 1; i<=10; i++) {
            System.out.println("Main thread is printing " + i);

            if(i == 5) {
                System.out.println("Main thread is pausing for 2 seconds");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

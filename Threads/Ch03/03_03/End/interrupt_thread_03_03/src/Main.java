public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread taskThread = new Thread(new MyRunnable());
        taskThread.start();
        //Thread.sleep(3000);
        taskThread.interrupt();
        Thread.sleep(3000);
        System.out.println(taskThread.isInterrupted());
    }
}

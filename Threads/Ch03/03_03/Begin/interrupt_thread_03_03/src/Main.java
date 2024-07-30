public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread taskThread = new Thread(new MyRunnable());
        taskThread.start();
    }
}

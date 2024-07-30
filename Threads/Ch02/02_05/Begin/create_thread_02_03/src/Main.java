public class Main {
    public static void main(String[] args) {

        for(int count = 1; count <=3; count++) {
            FirstThread thread = new FirstThread(count);
            thread.start();
        }

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        thread.start();
    }
}

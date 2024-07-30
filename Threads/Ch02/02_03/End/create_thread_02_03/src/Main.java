public class Main {
    public static void main(String[] args) {
        FirstThread thread1 = new FirstThread();
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
    }
}

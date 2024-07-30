public class Marks implements Runnable {

    int[] marks;

    public Marks(int[] marks) {
        this.marks = marks;
    }

    @Override
    public void run() {
        for(int i = 0; i<10; i++) {
            Double points = Math.random() * 100;
            marks[i] = points.intValue();
            System.out.println("Mark entered: " + marks[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class LoopThread extends Thread {
    private String taskName;
    private int start, end;

    public LoopThread(String name, String taskName, int start, int end) {
        super(name);
        this.taskName = taskName;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + taskName + ": " + i);
            try {
                Thread.sleep(200); // simulate some work
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished execution");
    }
}

public class ThreadJoinExample {
    public static void main(String[] args) {
        LoopThread t1 = new LoopThread("Thread-1", "Printing numbers", 1, 5);
        LoopThread t2 = new LoopThread("Thread-2", "Printing squares", 1, 5);

        System.out.println("Main thread: starting t1 and t2");

        t1.start();
        t2.start();

        try {
            t1.join(); // main thread waits for t1 to finish
            t2.join(); // main thread waits for t2 to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting");
        }

        System.out.println("Main thread: both t1 and t2 have finished");
        System.out.println("Main thread: execution complete");
    }
}

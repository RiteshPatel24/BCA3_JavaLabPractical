class MyThread extends Thread {
    public MyThread(String name) {
        super(name); // sets thread name via Thread constructor
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread Name: " + Thread.currentThread().getName()
                    + " | Priority: " + Thread.currentThread().getPriority()
                    + " | Count: " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class ThreadPriorityExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread-One");
        MyThread t2 = new MyThread("Thread-Two");
        MyThread t3 = new MyThread("Thread-Three");

        // Setting names (alternative to constructor, shown for demonstration)
        t1.setName("Worker-A");

        // Setting priorities
        t1.setPriority(Thread.MIN_PRIORITY);   // priority = 1
        t2.setPriority(Thread.NORM_PRIORITY);  // priority = 5 (default)
        t3.setPriority(Thread.MAX_PRIORITY);   // priority = 10

        System.out.println("Main thread name: " + Thread.currentThread().getName());
        System.out.println("Main thread priority: " + Thread.currentThread().getPriority());

        System.out.println("\n--- Starting threads ---\n");

        t1.start();
        t2.start();
        t3.start();
    }
}

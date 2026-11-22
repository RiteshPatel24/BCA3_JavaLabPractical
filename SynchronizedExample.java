class Counter {
    private int count = 0;

    // synchronized method ensures only one thread can execute this at a time
    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " incremented count to " + count);
    }

    public int getCount() {
        return count;
    }
}

class MyThread extends Thread {
    private Counter counter;

    public MyThread(String name, Counter counter) {
        super(name);
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment();
            try {
                Thread.sleep(100); // simulate some work
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class SynchronizedExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(); // shared resource

        MyThread t1 = new MyThread("Thread-1", counter);
        MyThread t2 = new MyThread("Thread-2", counter);

        t1.start();
        t2.start();

        t1.join(); // wait for t1 to finish
        t2.join(); // wait for t2 to finish

        System.out.println("\nFinal Count: " + counter.getCount());
    }
}

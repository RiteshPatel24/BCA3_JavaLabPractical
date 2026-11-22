class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread running, count: " + i);
            try {
                Thread.sleep(500); // pause 500ms between prints
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        System.out.println("Main thread started");

        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable); // pass Runnable object to Thread
        t1.start(); // starts the new thread and calls run()

        System.out.println("Main thread continues to execute...");
    }
}

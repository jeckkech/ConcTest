public class MainRunnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In a thread: " + Thread.currentThread().getName());
                System.out.println("With priority: " + Thread.currentThread().getPriority());
                throw new RuntimeException("Exception!!11");
            }
        });
        thread.setName("NewWorkerThread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("An exception occured: " + t.getName() + " with a trace: " + e.getMessage());
        });

        System.out.println("In a thread before: " + Thread.currentThread().getName());
        thread.start();
        System.out.println("In a thread after: " + Thread.currentThread().getName());

    }

}

public class MainExtentsThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new NewThread();

        thread.start();

    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
            setName("NewThread");
            System.out.println("Thread " + Thread.currentThread().getName() + " is running!");
        }
    }
}

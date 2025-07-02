import java.util.concurrent.Semaphore;

public class CHERIF_TPSemaphore {

    private static final int NB_THREADS = 3;
    private static final int NB_ITERATIONS = 5;

    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {

        for (int i = 0; i < NB_THREADS; i++) {
            final int threadId = i;
            Thread t = new Thread(() -> {
                for (int j = 0; j < NB_ITERATIONS; j++) {
                    try {
                        semaphore.acquire();
                        System.out.println("Thread " + threadId + " entre dans la section critique.");
                        Thread.sleep(100); // simulation de traitement
                        System.out.println("Thread " + threadId + " sort de la section critique.");
                        semaphore.release();
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }
}

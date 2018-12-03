import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicExecutorService {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(10);
                        System.out.println("Hello World");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
            executorService.execute(() -> {  // Using Lambdas
                try {
                    Thread.sleep(5);
                    System.out.println("Hello World2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            executorService.shutdown(); // Always shutdown at the main exit
        }
    }

}

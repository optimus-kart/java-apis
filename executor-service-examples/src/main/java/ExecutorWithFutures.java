import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorWithFutures {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            List<Future<Integer>> futures = new ArrayList<>();
            int[] toCalculate = {10, 3, 2};
            for (int num : toCalculate) {
                futures.add(executorService.submit(new FactorialCalculator(num)));
            }
            for (Future<Integer>f:futures){
                System.out.println("Result:"+f.get());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }


    }
}


class FactorialCalculator implements Callable {
    private int number;


    FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        Integer result = 1;
        if (this.number==0){
            return result;
        }
        else {
            for (int i=2; i<=this.number;i++){
                result = result*i;
            }
        }
        return result;
    }
}
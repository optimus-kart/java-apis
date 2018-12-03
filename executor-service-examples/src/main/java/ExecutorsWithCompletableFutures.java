import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsWithCompletableFutures {


    public static void main(String[] args) {

        // supplyAsync and thenAccept
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() ->
                "hello world").thenAccept(s -> System.out.println(s));

        // supplyAsync, thenApply thenAccept
        CompletableFuture<Void> future1 = CompletableFuture.supplyAsync(() ->
                "Hello World").thenApply(s -> s + " java").
                thenAccept(s -> System.out.println(s));

        // supplyAsync, theCombineAsync
        CompletableFuture<String> future2 =
                CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> future3 =
                CompletableFuture.supplyAsync(() -> " World combine");

        future2.thenCombineAsync(future3, (s1, s2) -> s1 + s2).
                thenAccept(s -> System.out.println(s));


        // Supply Async with ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> future4= CompletableFuture.supplyAsync(()->
                "hello " +
                "world with executor"+Thread.currentThread().getName(),
                executorService).thenAccept(s-> System.out.println(s));

    }


}

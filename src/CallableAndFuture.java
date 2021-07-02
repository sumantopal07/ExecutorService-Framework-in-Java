import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFuture {
    private static int INDEX=0;
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //create the pool
        ExecutorService service = Executors.newFixedThreadPool(100);


        // submit the tasks for execution
         List<Future> allFutures = new ArrayList<>();

         for(int i=0;i<100;i++){
             Future<Integer> future = service.submit(new Task());
             allFutures.add(future);
         }
         // 100 futures, with 100 placeholders

         // perform some unrelated operations

         // 100 seconds
         // perform some unrelated operations

         for(int i=0;i<100;i++){
             Future<Integer> future = allFutures.get(i);
             Integer result = future.get();
             System.out.println("Result of future #" + i +"="+result);
         }

         System.out.println("thread Name: " + Thread.currentThread().getName());

         service.shutdownNow();

    }
    static class Task implements Callable<Integer>{
            @Override
            public Integer call() throws Exception{
                Thread.sleep(3000);
                return INDEX++;
            }
        }
}

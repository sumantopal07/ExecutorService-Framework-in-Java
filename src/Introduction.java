import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Introduction {

    public static void main(String[] args) {

        ExecutorService service= Executors.newFixedThreadPool(10);

        for(int i=0;i<100;i++){
            service.execute(new Task());
        }
        /**
         * Creating new task and submitting them to services
         * Within the service it internally uses a blocking queue
         * In that queue it keeps storing all the tasks that
         * you have submitted
         * --> fetch the next task
         * --> execute the task
         *  The Blocking queue is thread safe
         *
         *  IDEAL POOL SIZE === NUMBER OF CORES IN THE CPU
         *
         * */
        //get the count of avaialble cores
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService serviceBetter= Executors.newFixedThreadPool(coreCount);

        for(int i=0;i<100;i++){
            serviceBetter.execute(new Task());
        }

        /**
         * For IO INTENSIVE OPERATIONS
         *
         * HIGHER THE THREADS BETTER
         * depends on rate of task submissions and average task wait time
         * */
        System.out.println("Thread NameXX: "+coreCount+ Thread.currentThread().getName());
    }
    static class Task implements Runnable{
        public void run(){
            System.out.println("Thread Name: "+ Thread.currentThread().getName());
        }
    }
}
/**
 *  creating a thread is an expensive operation
 *  new Thread creates a new thread each time it gets executed
 *
 *
 *  SOLUTION:
 *  Fixed Number of threads created upfront.
 *  Then each thread will pick a task and execute
 * */

public class TypesOfThreadPools {
    public static void main(String[] args) {


    }
}
/**
 * 1. FixedThreadPool [Introduction]
 * 2. CachedThreadPool [No fixed no. of threads nor BlockingQueue]
 *      Queue is replaced by SynchronousQueue(SIZE=1)
 *      Task gets stored in SynchronousQueue
 *      will search any available thread, if no thread found then
 *      creates and adds new thread to the threadPool.
 *
 *      Also has it has capability to kill thread if a thread is idle
 *      for more than 60 seconds
 *
 * 3. ScheduledThreadPool
 *      schedule the tasks to run after a time delay
 *      DelayQueue
 *
 * 4. SingleThreadedExecutor
 *      one thread always exists even if gets killed
 *
 *      to maintain order of execution of tasks
 *
 *
 *
 *
 * **/

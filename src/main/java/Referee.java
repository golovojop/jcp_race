import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public class Referee {
    public static final int CARS_COUNT = 4;
    public static final CountDownLatch startGate = new CountDownLatch(CARS_COUNT);
    public static final Semaphore tunnelEntry = new Semaphore(CARS_COUNT/2);

    public static final AtomicReference<String> winner = new AtomicReference(null);

}

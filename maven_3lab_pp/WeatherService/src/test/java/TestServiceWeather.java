import org.junit.Test;
import ru.mirea.DataSourceApi.ICustomQueue;
import ru.mirea.DataSourceImple.CustomQueue;
import ru.mirea.WeatherService.*;

public class TestServiceWeather {
    @Test
    public void main() throws InterruptedException {//TestMain1
        ICustomQueue inQueue = new CustomQueue(50);
        TaskGenerator tg = new TaskGenerator(50, inQueue);

        ThreadGenerator thGenerator = new ThreadGenerator(tg, 50);
        Thread threadGenerator = new Thread(thGenerator);
        threadGenerator.start();
        Thread.sleep(10000);

        System.out.println(inQueue.getQeue().size());

        System.out.println("outQueue:\n");

        CustomQueue outQueue = new CustomQueue(50);
        TaskExecutor te = new TaskExecutor(inQueue, outQueue);

        Thread threadExecutor1 = new Thread(te);
        Thread threadExecutor2 = new Thread(te);
        Thread threadExecutor3 = new Thread(te);
        threadExecutor1.start();
        threadExecutor2.start();
        threadExecutor3.start();


        Logger logger = new Logger();
        ThreadPrint printer = new ThreadPrint(logger, outQueue);
        Thread threadPrint = new Thread(printer);
        threadPrint.start();

        Thread.sleep(2000);

        threadExecutor1.interrupt();
        threadExecutor2.interrupt();
        threadExecutor3.interrupt();
        threadPrint.interrupt();
    }
}

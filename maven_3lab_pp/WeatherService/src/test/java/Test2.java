/*import org.junit.Test;
import ru.mirea.DataSourceApi.ICustomQueue;
import ru.mirea.DataSourceApi.ITask;
import ru.mirea.DataSourceImple.CustomQueue;
import ru.mirea.DataSourceImple.Task;
import ru.mirea.WeatherService.TaskExecutor;
import ru.mirea.WeatherService.ThreadExecutor;

import java.util.Date;

public class Test2 {

    @Test
    public void main() throws InterruptedException {

        int sizeOfQueue = 1;
        ICustomQueue inQueue = new CustomQueue(sizeOfQueue);
        Date dateTest = new Date();
        ITask taskTest = new Task(0,"Paris", dateTest);
        inQueue.setQeue(taskTest); 
        String weatherForTest = "weather:+19";
        
        System.out.println(taskTest.getId());
        System.out.println(taskTest.getDate());
        System.out.println(taskTest.getCity());
        System.out.println(weatherForTest);
        
        ICustomQueue outQueue = new CustomQueue(sizeOfQueue);
        TaskExecutor te = new TaskExecutor(inQueue, outQueue);
        ThreadExecutor thExecutor = new ThreadExecutor(te);
        Thread threadExecutor1 = new Thread(thExecutor);
        threadExecutor1.start();
        Thread.sleep(10);
        threadExecutor1.interrupt();
        
        ITask taskOut = outQueue.getQeue().poll();
        String weatherOut = taskOut.getWeather();
        if( "Paris".equals(taskOut.getCity()) && 0 == taskOut.getId() && dateTest.equals(taskOut.getDate())) System.out.println("OK");
        else System.out.println("ERROR");
        if(weatherOut.equals(weatherForTest)) System.out.println("OK");
        else System.out.println("ERROR");
        
        
    }
}*/
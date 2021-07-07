package ru.mirea.WeatherService;

import ru.mirea.DataSourceApi.ICustomQueue;
import ru.mirea.DataSourceApi.ITask;

import java.util.*;

public class TaskExecutor implements Runnable {

    Map<String, String> forecasts = new HashMap<>();
    
    

    Random rand = new Random();

    public final Queue<ITask> inQueue;
    public final Queue<ITask> outQueue;

    public int randWeather;

    public TaskExecutor(ICustomQueue qu, ICustomQueue outQueue) {
        forecasts.put("Moscow", "+15");
        forecasts.put("London", "+17");
        forecasts.put("Paris","+19");
        forecasts.put("Ivanovo","+11");
        forecasts.put("Tokio","+20");
        forecasts.put("Kiev","+30");
        forecasts.put("Praga","+13");
        forecasts.put("Washington","+16");
        forecasts.put("Warszawa","+12");
        forecasts.put("Ottawa","+23");
        inQueue = qu.getQeue();
        this.outQueue = outQueue.getQeue();

    }

    /**
     * Ранее execute. Решает задачи, пока не будет вызван Thread.interrupt.
     */
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            if (inQueue.size() > 0) {
                ITask firstElemQue;
                synchronized (inQueue) {
                    firstElemQue = inQueue.poll();
                }
                if (firstElemQue != null) {
                    String city = firstElemQue.getCity();
                    firstElemQue.setWeather("weather:" + forecasts.get(city));
                    synchronized (outQueue) {
                        outQueue.add(firstElemQue);
                    }
                } else {
                    System.out.println("ERROR");
                }
            }
        }
    }
}

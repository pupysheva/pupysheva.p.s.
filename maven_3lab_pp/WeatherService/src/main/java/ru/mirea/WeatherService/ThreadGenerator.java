package ru.mirea.WeatherService;

import ru.mirea.DataSourceApi.ICustomQueue;

/**
 *
 * @author pupys
 */
public class ThreadGenerator implements Runnable {

    private TaskGenerator taskGenerator;
    ICustomQueue inQ;
    private boolean isThreadOn = true;
    private int queueSize;

    public ThreadGenerator(TaskGenerator taskGenerator, int queueSize) {
        this.taskGenerator = taskGenerator;
        this.inQ = taskGenerator.getQueue();
        this.queueSize = queueSize;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < queueSize) {
            try {
                taskGenerator.generate(i);
                i++;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

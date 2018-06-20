package ru.mirea.WeatherService;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ru.mirea.DataSourceApi.ICustomQueue;
import ru.mirea.DataSourceApi.ITaskGenerator;

/**
 *
 * @author pupys
 */
public class ThreadGenerator implements Runnable {

    private ITaskGenerator taskGenerator;
    ICustomQueue inQ;
    private boolean isThreadOn = true;
    private int queueSize;

    public ThreadGenerator(ITaskGenerator taskGenerator, int queueSize) {
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

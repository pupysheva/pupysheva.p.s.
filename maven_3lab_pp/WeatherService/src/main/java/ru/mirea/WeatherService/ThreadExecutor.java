package ru.mirea.WeatherService;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pupys
 */
import ru.mirea.DataSourceApi.ITask;

import java.util.*;
public class ThreadExecutor implements Runnable {
    private final TaskExecutor taskExecutor;
    Queue<ITask> outQueue;
    Queue<ITask> inQueue;
    //private int queueSize;

    public ThreadExecutor(TaskExecutor taskExecutor/*, int queueSize*/) {
        this.taskExecutor = taskExecutor;
        this.inQueue = taskExecutor.inQueue;
        this.outQueue = taskExecutor.outQueue;
        //this.queueSize = queueSize;
    }

    @Override
    public void run() {
       taskExecutor.executor();        
    }
}


package ru.mirea.WeatherService;

import ru.mirea.DataSourceApi.ICustomQueue;

import java.util.*;

public class ThreadPrint implements Runnable {

    private Logger logger;
    private ICustomQueue outQueue;

    public ThreadPrint(Logger logger, ICustomQueue outQueue) {
        this.logger = logger;
        this.outQueue = outQueue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
                logger.log(outQueue);
        }
    }
}

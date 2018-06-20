package ru.mirea.WeatherService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pupys
 */
import ru.mirea.DataSourceApi.ICustomQueue;
import ru.mirea.DataSourceApi.ITask;

import java.util.*;
public class Logger {
    public static void log(ICustomQueue outQueue) {
        ITask printOutQueue;
        synchronized (outQueue) {
            printOutQueue = outQueue.getQeue().poll();
        }
        if (printOutQueue != null) {
            printOutQueue.printTask();
            System.out.println("" + printOutQueue.getWeather());
        }
    }
}
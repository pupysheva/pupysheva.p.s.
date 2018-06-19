package ru.mirea.DataSourceImple;

import ru.mirea.DataSourceApi.ICustomQueue;
import ru.mirea.DataSourceApi.ITask;

import java.util.*;
public class CustomQueue implements ICustomQueue {
    private int size;
    private Queue<ITask> Queue = new LinkedList<ITask>();
    public CustomQueue(int size){
	this.size = size;
    }
    
    public void setQeue(ITask task) {
        if (Queue.size()<size) Queue.add(task);
    }
    
    public Queue<ITask> getQeue(){
        return Queue;
    }
}

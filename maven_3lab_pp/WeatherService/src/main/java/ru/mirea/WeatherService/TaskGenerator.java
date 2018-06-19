package ru.mirea.WeatherService;
import ru.mirea.DataSourceApi.ICustomQueue;
import ru.mirea.DataSourceApi.ITask;
import ru.mirea.DataSourceImple.Task;

import java.util.*;

public class TaskGenerator {

    private List<String> cities = new ArrayList<String>();
    public final ICustomQueue queue;
    public final int count;

    public TaskGenerator(int count, ICustomQueue queue) {
        this.queue = queue;
        this.count = count;
        cities.add("Moscow");
        cities.add("London");
        cities.add("Paris");
        cities.add("Ivanovo");
        cities.add("Tokio");
        cities.add("Kiev");
        cities.add("Praga");
        cities.add("Washington");
        cities.add("Warszawa");
        cities.add("Ottawa");
    }

    public void generate(int i) {

        int currentPosition = i % cities.size();
        ITask task = new Task(i, cities.get(currentPosition), new Date());
        synchronized (queue) {
            queue.setQeue(task);
        }

    }
}

/*package ru.mirea.DataSourceImple;
import java.util.*;
import ru.mirea.DataSourceApi.ICustomQueue;
import ru.mirea.DataSourceApi.ITaskGenerator;

public class TaskGenerator implements ITaskGenerator {

    private List<String> cities = new ArrayList<String>();
    public final ICustomQueue queue;
    public final int count;

    TaskGenerator(int count, ICustomQueue queue) {
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

    @Override
    public int getCount(){
        return count;
    }

    public ICustomQueue getQueue(){
        return queue;
    }

    @Override
    public void generate(int i) {

        int currentPosition = i % cities.size();
        Task task = new Task(i, cities.get(currentPosition), new Date());
        synchronized (queue) {
            queue.setQeue(task);
        }

    }
}
*/
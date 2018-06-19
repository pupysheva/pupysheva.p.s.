package ru.mirea.DataSourceImple;
import ru.mirea.DataSourceApi.ITask;
import java.util.*;
public class Task implements ITask {
    private final int id;
    private final Date date;
    private final String city;
    private String weather;

    public Task(int id, String city, Date date) {
        this.id = id;
        this.date = date;
        this.city = city;
    }

    @Override
    public void printTask() {
        System.out.println(id);
        System.out.println(date);
        System.out.println(city);
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public Date getDate() {
        return date;
    }
    @Override
    public String getCity() {
        return city;
    }
    @Override
    public String getWeather() {
        return weather;
    }
    @Override
    public void setWeather(String tmpWeather) {
        this.weather = tmpWeather;
    }
}
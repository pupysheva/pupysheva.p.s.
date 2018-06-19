package ru.mirea.DataSourceApi;

import java.util.Date;
/**
 * Интерфейс для хранилища тасков.
 */
public interface ITask {
    /**
     * Печатает задачу.
     */
    public void printTask();

    /**
     * Получение <Code>id</Code>.
     * @return <Code>id</Code>.
     */
    public int getId();

    /**
     * Получение даты.
     * @return дата.
     */
    public Date getDate();

    /**
     * Получние города.
     * @return Строка, которая представляет город.
     */
    public String getCity();

    /**
     * Получение Погоды.
     * @return погода.
     */
    public String getWeather();

    /**
     * Устанавливает погоду.
     * @param tmpWeather - погода типа строка.
     */
    public void setWeather(String tmpWeather);
}

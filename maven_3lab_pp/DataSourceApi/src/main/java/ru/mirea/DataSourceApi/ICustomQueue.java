package ru.mirea.DataSourceApi;

import java.util.Queue;

/**
 * Интерфейс, который описывает работу хранилища очереди.
 */
public interface ICustomQueue {
    /**
     * Добавить задачу в очередь.
     * @param task - задача, является элементом очереди.
     */
    public void setQeue(ITask task);

    /**
     * Получить очередь.
     * @return Ссылка на очередь.
     */
    public Queue<ITask> getQeue();
}

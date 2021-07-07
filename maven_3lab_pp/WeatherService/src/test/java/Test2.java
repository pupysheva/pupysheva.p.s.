import org.junit.Test;
import ru.mirea.DataSourceApi.ICustomQueue;
import ru.mirea.DataSourceApi.ITask;
import ru.mirea.DataSourceImple.CustomQueue;
import ru.mirea.DataSourceImple.Task;
import ru.mirea.WeatherService.TaskExecutor;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test2 {

    @Test
    public void main() throws InterruptedException {

        // ----------------------- Инцилизация данных -----------------------

        int sizeOfQueue = 1;                                    // Размер очереди
        ICustomQueue inQueue = new CustomQueue(sizeOfQueue);    // Инцилизируем очередь входных задач
        Date dateTest = new Date();                             // Инцилизируем дату
        ITask taskTest = new Task(0,"Paris", dateTest);  // Создаём тест-задачу.
        inQueue.setQeue(taskTest);                              // Добавляем задачу в очередь.
        String weatherForTest = "weather:+19";                  // Создаём погоду, которую мы ожидаем.

        // ----------------------- Печать данных -----------------------

        System.out.println(taskTest.getId());   // Печать идентификатора.
        System.out.println(taskTest.getDate()); // Печать даты.
        System.out.println(taskTest.getCity()); // Печать города.
        System.out.println(weatherForTest);     // Печать погоды.

        // ----------------------- Запуск тестируемого модуля -----------------------
        
        ICustomQueue outQueue = new CustomQueue(sizeOfQueue);   // Инцилизируем очередь выходных задач.
        TaskExecutor te = new TaskExecutor(inQueue, outQueue);  // Создаём в памяти систему принятия решений.
        Thread threadExecutor1 = new Thread(te);                // Создаём поток с аргументом Runnable модулём.
        threadExecutor1.start();                                // Запускаем систему принятия решений потоком.
        Thread.sleep(10);                                  // Ожидаем, когда предположительно разрешатся все задачи.
        threadExecutor1.interrupt();                            // Останавливаем работу потока принятия решений.

        // ------------ Проверка выходных данных тестируемого модуля ------------

        // Проверка количества выходной очереди.
        assertEquals("Ожидалось в выходной очереди один элемент. В выходной очереди не один элемент. Возможно, ни одного или более 1.", 1, outQueue.getQeue().size());

        // Проверка задачи.
        ITask taskOut = outQueue.getQeue().poll();  // Извлекаем элемент.
        assertTrue("Ожидалось, что taskOut не пустой. Он пуст!", taskOut != null);
        assertEquals("Ожидался город Paris, но в выходной задаче другой город.", "Paris", taskOut.getCity());
        assertEquals("Ожидался идентификатор задачи 0 (так как он единственный), но он не равен нулю.", 0, taskOut.getId());
        assertEquals("Ожидалась дата такая же, как и в начале, но в процессе она была изменена.", dateTest, taskOut.getDate());
        System.out.println("OK");

        // Проверка выходной погоды.
        assertEquals("Ожидалась иная выходная погода.", weatherForTest, taskOut.getWeather());
        System.out.println("OK");
        
        
    }
}

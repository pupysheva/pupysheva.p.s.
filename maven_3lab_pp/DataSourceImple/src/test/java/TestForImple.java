import org.junit.Test;
import ru.mirea.DataSourceImple.Task;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestForImple {

    @Test
    public void startTestImple(){
        Date d = new Date();
        Task a = new Task(0, "Moscow", d);

        assertEquals(0, a.getId());
        assertEquals("Moscow", a.getCity());
        assertEquals(d, a.getDate());
        assertEquals(null, a.getWeather());
        System.out.println("Testing Impl!");
    }
}

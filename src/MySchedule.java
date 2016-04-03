import java.util.Map;
import java.util.Set;

public class MySchedule {

    public static void printMessage(Map<Long, String> map) throws InterruptedException {

        for (Map.Entry<Long, String> entry : map.entrySet()) {
            System.out.println(entry.getValue()+ " " + entry.getKey()/1000 + " сек");
           Thread.currentThread().sleep((Long) entry.getKey());
        }
    }
}

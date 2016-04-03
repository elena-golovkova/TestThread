import java.io.File;
import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException, IOException {
        /*System.out.println("First task~~~~~~~~~~");
        Thread myThread = new NewThread();
       *//* Thread myThread1 = new Thread(new ThreadInterface());
        myThread1.setDaemon(true);
        myThread1.start();*//*

        myThread.setDaemon(true);
        System.out.println(myThread.getState());
        myThread.start();
        System.out.println(myThread.getState());
        Thread.sleep(5000);
        myThread.isInterrupted();
        System.out.println(myThread.getState());


      *//*  System.out.println("Second task~~~~~~~~~~");
        Map<Long, String> map = new LinkedHashMap<>();
        map.put(5000l, "&#x412;&#x430;&#x441;&#x44c;&#x43a;&#x430;");
        map.put(2000l, "&#x41a;&#x43e;&#x43b;&#x44c;&#x43a;&#x430;");
        map.put(3000l, "&#x41e;&#x43b;&#x44c;&#x43a;&#x430;");

        MySchedule.printMessage(map);*/
        String path = "src\\old\\musicic\\";
        String path2 = "src\\new\\";

        CopingWithThreads.copy(path,path2);

    }

}

package kingdombpe.logger;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Logger {
    private ArrayList<String> logs;
    private static Logger instance;
    private static Lock locker = new ReentrantLock();


    private Logger() {
        logs = new ArrayList<>();
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (locker) {
                if (instance == null)
                    instance = new Logger();
            }
        }
        return instance;
    }

    public void log(String txt) {
        logs.add(txt);
        System.out.println(txt);
    }

    public ArrayList<String> getLogs() {
        return logs;
    }
}

package kingdombpe.mining;

import kingdombpe.logger.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ValuableDictionary {
    private Map<Integer, String> dict = new HashMap<>();
    private static ValuableDictionary instance;
    private static Lock locker = new ReentrantLock();

    private ValuableDictionary() {
        dict.put(1, "Wooden Coin");
        dict.put(2, "Gold Nugget");
        dict.put(3, "Jewel");
        dict.put(4, "Ruby");
        dict.put(5, "Diamond");
    }

    public static String get(int key) {
        if (instance == null) {
            synchronized (locker) {
                if (instance == null)
                    instance = new ValuableDictionary();
            }
        }
        return instance.dict.get(key);
    }
}

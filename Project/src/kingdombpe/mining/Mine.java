package kingdombpe.mining;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Mine
{
    private static Map<Integer, Valuable> valuables = new HashMap<>();

    public static Valuable getValuable(int key)
    {
        try
        {
            if (key < 1 || key > 5)
            {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Illegal argument exception **** key range : [1,5]");
        }
        finally
        {

            Valuable item = valuables.get(key);

            if (item == null)
            {
                synchronized (valuables)
                {
                    item = valuables.get(key);
                    if (item == null)
                    {
                        item = new Jewels(ValuableDictionary.get(key));
                        valuables.put(key, item);
                    }
                }

            }
            return new Jewels(item.getName(), key * ThreadLocalRandom.current().nextInt(1, 51));
        }
    }
    }


package kingdombpe.mining;


import java.util.ArrayList;

public class Deposit  {

    private ArrayList<Valuable> valuables;
    private int max;

    public Deposit(int max)
    {
        try
        {
            this.max = max;
            valuables = new ArrayList<Valuable>();
            if (this.max < 1 )
            {
                throw new IllegalArgumentException();

            }

        }
        catch (IllegalArgumentException e){
            System.out.println("Has to be a positive integer >0");
        }
    }
    public synchronized void insertValuable(Valuable valuable) {
        while (valuables.size() >= max) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        valuables.add(valuable);
        notifyAll();
    }

    public synchronized Valuable takeValuable() {
        while (valuables.size() <= 0)
        {
            try {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        Valuable returnValuable = valuables.remove(0);
//        valuables.remove(0);
        notifyAll();
        return returnValuable;
    }

    public ArrayList<Valuable> getValuables()
    {
        return valuables;
    }


}

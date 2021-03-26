package kingdombpe.transport;

import kingdombpe.logger.Logger;
import kingdombpe.mining.Deposit;

import java.lang.Runnable;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import actors.Actor;
import kingdombpe.mining.Valuable;
import proxy.TreasureRoomDoor;

import static java.lang.Thread.sleep;

public class ValuableTransporter extends Actor {
    private Deposit deposit;
    private TreasureRoomDoor treasureRoomDoor;
    private ArrayList<Valuable> valuables;

    public ValuableTransporter(TreasureRoomDoor treasureRoomDoor, Deposit deposit) {
        super("transporter");
        this.treasureRoomDoor = treasureRoomDoor;
        this.deposit = deposit;
        valuables = new ArrayList<Valuable>();
    }


    @Override
    public void run() {
        while (true) {
            int wantedValue = ThreadLocalRandom.current().nextInt(50, 251);

            Logger.getInstance().log("Transporter >> Value: " + wantedValue + " _______________________________");

            while(getValueOfValuables(valuables) < wantedValue)
                valuables.add(deposit.takeValuable());

            Logger.getInstance().log("Transporter >> Actual value: " + getValueOfValuables(valuables));

            Logger.getInstance().log("Transporter >> " + valuables.toString());
            //sleep = going to treasure room
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            for(Valuable val : valuables) {
                try {
                    treasureRoomDoor.add(val, this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            valuables.clear();

            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private int getValueOfValuables(ArrayList<Valuable> valuables) {
        int value = 0;
        for (Valuable valuable : valuables) {
            value += valuable.getValue();
        }
        return value;
    }
}

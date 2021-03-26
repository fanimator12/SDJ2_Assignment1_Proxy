package actors;

import kingdombpe.logger.Logger;
import kingdombpe.mining.Valuable;
import proxy.TreasureRoomDoor;

import java.util.ArrayList;

public class Accountant extends Actor {
    private TreasureRoomDoor treasureRoomDoor;

    public Accountant(TreasureRoomDoor treasureRoomDoor) {
        super("accountant");
        this.treasureRoomDoor = treasureRoomDoor;
    }

    @Override
    public void run() {
        while (true) {
            int valuablesValue = 0;
            ArrayList<Valuable> valuables = treasureRoomDoor.look();
            for(Valuable valuable : valuables) {
                valuablesValue += valuable.getValue();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Logger.getInstance().log("Accountant >> Total value of valuables inside the Treasure Room is: " + valuablesValue + " pesos");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

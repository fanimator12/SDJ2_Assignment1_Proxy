package actors;

import kingdombpe.logger.Logger;
import kingdombpe.mining.Valuable;
import proxy.TreasureRoom;
import proxy.TreasureRoomDoor;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class King extends Actor {
    private TreasureRoomDoor treasureRoomDoor;

    public King(TreasureRoomDoor treasureRoomDoor) {
        super("king");
        this.treasureRoomDoor = treasureRoomDoor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int price = ThreadLocalRandom.current().nextInt(50, 151);
            boolean priceMet = false;
            int valuablesValue = 0;

            ArrayList<Valuable> treasure = treasureRoomDoor.look();
            ArrayList<Valuable> valuables = new ArrayList<Valuable>();

            for (Valuable v : treasure) {
                Valuable val = null;
                try {
                    val = treasureRoomDoor.retrieve(this);
                    valuables.add(val);
                    valuablesValue += val.getValue();
                } catch (Exception e) {
                    //
                }
                if (valuablesValue >= price) {
                    priceMet = true;
                    break;
                }
            }

            if (!priceMet) {
                for (Valuable valuable : valuables) {
                    try {
                        treasureRoomDoor.add(valuable, this);
                    } catch (Exception e) {
                        //
                    }
                }
            }
        }
    }
}

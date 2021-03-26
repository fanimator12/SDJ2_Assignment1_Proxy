import actors.Accountant;
import actors.King;
import kingdombpe.mining.Deposit;
import kingdombpe.mining.Miner;
import kingdombpe.transport.ValuableTransporter;
import proxy.TreasureRoom;
import proxy.TreasureRoomDoor;
import proxy.TreasureRoomGuardsman;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Deposit dep = new Deposit(5);
        TreasureRoom room = new TreasureRoom();
        TreasureRoomDoor guard = new TreasureRoomGuardsman(room);
        new Thread(new ValuableTransporter(guard, dep)).start();
        sleep(300);
        new Thread(new Miner(dep)).start();
        sleep(300);
        new Thread(new Miner(dep)).start();
        sleep(300);
        new Thread(new Miner(dep)).start();
        sleep(300);
        new Thread(new Accountant(guard)).start();
        sleep(300);
        new Thread(new King(guard)).start();
    }
}

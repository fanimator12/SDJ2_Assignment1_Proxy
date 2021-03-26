package kingdombpe.mining;

import actors.Actor;

import java.lang.Runnable;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;


public class Miner extends Actor {

    private Deposit deposit;

    public Miner(Deposit deposit) {
        super("miner");
        this.deposit = deposit;
    }

    @Override
    public void run() {
        while (true) {
            int value = ThreadLocalRandom.current().nextInt(1, 6);

            deposit.insertValuable(Mine.getValuable(value));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

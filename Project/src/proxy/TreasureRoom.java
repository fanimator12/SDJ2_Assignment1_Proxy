package proxy;

import actors.Actor;
import kingdombpe.logger.Logger;
import kingdombpe.mining.Valuable;

import java.util.ArrayList;

public class TreasureRoom implements TreasureRoomDoor {
    private ArrayList<Valuable> valuables;

    public TreasureRoom(){
        valuables = new ArrayList<Valuable>();
    }

    @Override
    public void add(Valuable valuable, Actor actor) {
        valuables.add(valuable);
        Logger.getInstance().log("Treasure room >> " + valuable + " has been added to the tresure room");
    }

    @Override
    public Valuable retrieve(Actor actor) {
        Valuable valuable = valuables.get(0);
        valuables.remove(0);
        Logger.getInstance().log("Treasure room >> " + valuable + " has been removed from the tresure room");
        return valuable;
    }

    @Override
    public ArrayList<Valuable> look() {
        return (ArrayList<Valuable>) valuables.clone();
    }
}

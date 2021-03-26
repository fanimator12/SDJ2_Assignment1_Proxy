package proxy;

import actors.Actor;
import kingdombpe.mining.Valuable;

import java.util.ArrayList;

public interface TreasureRoomDoor {
    void add(Valuable valuable, Actor actor) throws Exception;
    Valuable retrieve(Actor actor) throws Exception;
    ArrayList<Valuable> look();
}

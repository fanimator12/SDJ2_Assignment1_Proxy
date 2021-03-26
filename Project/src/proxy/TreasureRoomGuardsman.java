package proxy;

import actors.Actor;
import kingdombpe.mining.Valuable;

import java.util.ArrayList;

public class TreasureRoomGuardsman implements TreasureRoomDoor{

    private TreasureRoom treasureRoom;

    public TreasureRoomGuardsman(TreasureRoom treasureRoom){
        this.treasureRoom = treasureRoom;
    }

    @Override
    public void add(Valuable valuable, Actor actor) throws Exception {
        String type = actor.getType();
        if(type.equals("king") || type.equals("accountant") || type.equals("transporter")){
            treasureRoom.add(valuable, null);
        } else {
            System.out.println("Access denied");
        }
    }

    @Override
    public Valuable retrieve(Actor actor) throws Exception {
        String type = actor.getType();
        if(type.equals("king")){
            return treasureRoom.retrieve(null);
        } else {
            System.out.println("Access denied");
        }
        return null;
    }

    public ArrayList<Valuable> look() {
        return treasureRoom.look();
    }

}

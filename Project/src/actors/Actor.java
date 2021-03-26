package actors;

public abstract class Actor implements Runnable {
    private String type;

    public Actor(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

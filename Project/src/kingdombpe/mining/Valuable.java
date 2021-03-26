package kingdombpe.mining;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Valuable {
    private String name;
    private int value;

    public Valuable(String name) {
        this.name = name;
    }

    public Valuable(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return String.format("%s value: %d", getName(), getValue());
    }
}

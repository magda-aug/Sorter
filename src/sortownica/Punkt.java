package sortownica;

public class Punkt {
    private final int x;
    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Punkt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return Integer.toString(x) + " " + Integer.toString(y) + System.lineSeparator();
    }
}

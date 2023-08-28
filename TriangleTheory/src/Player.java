import java.awt.*;
import java.awt.event.*;
import java.awt.Component.*;

public class Player extends Rectangle {

    private int x, y;
    private int size;
    public int getx() {
        return x;
    }
    public int gety() {
        return y;
    }
    public Player(int x, int y,int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, size, size);

    }
}
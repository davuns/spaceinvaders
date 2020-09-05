import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Mag extends Moving {
    private int spd;

    public Mag() {
        this(0, 0, 0);
    }

    public Mag(int x, int y) {
        super(x, y);
    }

    public Mag(int x, int y, int s) {
        super(x, y);
        spd = s;
    }

    public void setSpd(int s) {
        spd = s;
    }

    public int getSpd() {
        return spd;
    }

    public void draw(Graphics window) {
        window.setColor(Color.yellow);
        window.fillRect(getX(), getY(), 10, 10);
    }

    public void move(String direction) {
        if (direction.equals("up")) {
            setY(getY() - spd);
        }
    }

    public String toString() {
        return super.toString() + " " + getSpd();
    }
}
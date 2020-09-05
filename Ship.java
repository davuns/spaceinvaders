import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends Moving {
    private int spd;
    private Image img;

    public Ship() {
        this(10, 10, 10, 10, 10);
    }

    public Ship(int x, int y) {
        super(x, y);
    }

    public Ship(int x, int y, int s) {
        super(x, y);
        spd = s;
    }

    public Ship(int x, int y, int w, int h, int s) {
        super(x, y, w, h);
        spd = s;
        try {
            URL url = getClass().getResource("ship.jpg");
            img = ImageIO.read(url);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public void setSpd(int s) {
        spd = s;
    }

    public int getSpd() {
        return spd;
    }

    public void move(String direction) {
        if (direction.equals("left")) {
            setX(getX() - spd);
        }
        if (direction.equals("right")) {
            setX(getX() + spd);
        }
        if (direction.equals("up")) {
            setY(getY() - spd);
        }
        if (direction.equals("down")) {
            setY(getY() + spd);
        }
    }

    public void draw(Graphics window) {
        window.drawImage(img, getX(), getY(), getW(), getH(), null);
    }

    public String toString() {
        return super.toString() + " " + getSpd();
    }
}
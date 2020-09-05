import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends Moving {
    private int spd;
    private Image img;

    public Alien() {
        this (0, 0, 30, 30, 0);
    }

    public Alien(int x, int y) {
        super(x, y);
    }

    public Alien(int x, int y, int s) {
        super(x, y);
        spd = s;
    }

    public Alien(int x, int y, int w, int h, int s) {
        super(x, y, w, h);
        spd = s;
        try {
            URL url = getClass().getResource("alien.jpg");
            img = ImageIO.read(url);
        }
        catch(Exception e) {
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
        setX(getX() + spd);
    }

    public void draw(Graphics window) {
        window.drawImage(img, getX(), getY(), getW(), getH(), null);
    }

    public String toString() {
        return "";
    }
}
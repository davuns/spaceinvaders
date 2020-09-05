import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class Power extends Moving {
    private int spd;
    private Image img;

    public Power() {
        this(0, 0, 30, 30, 0);
    }

    public Power(int x, int y) {
        super(x, y);
    }

    public Power(int x, int y, int s) {
        super(x, y);
        spd = s;
    }

    public Power(int x, int y, int w, int h, int s) {
        super(x, y, w, h);
        spd = s;
        try {
            URL url = getClass().getResource("power.jpg");
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
        setX(getX() + spd);
    }

    public void moveDown() {
        if (getX() < 0 || getX() > 750) {
            setY(getY() + 50);
            setSpd(getSpd() * -1);
        }
    }

    public void draw(Graphics window) {
        window.drawImage(img, getX(), getY(), getW(), getH(), null);
    }

    public boolean collide(List<Mag> shots, Graphics window, Power power) {
        for (int i = 0; i < shots.size(); i += 1) {
            try {
                if (shots.get(i).Collide(power)) {
                    shots.remove(i);
                    power.setH(0);
                    power.setW(0);
                    return true;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String toString() {
        return "";
    }
}
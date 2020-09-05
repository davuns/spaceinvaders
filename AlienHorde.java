import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde {
    private List<Alien> horde;
    private int t;

    public AlienHorde(int size) {
        horde = new ArrayList<Alien>();
    }

    public void add(Alien a) {
        horde.add(a);
    }

    public void drawAll(Graphics window) {
        for (Alien a : horde) {
            a.draw(window);
        }
    }

    public void moveAll() {
        t += 1;
        for (Alien a : horde) {
            if (t <= 200) {
                a.move("left");
            }
            else if (t <= 300) {
                a.move("down");
            }
            else if (t <= 500) {
                a.move("right");
            }
            else if (t <= 600) {
                a.move("up");
            }
            else {
                t = 0;
            }
        }
    }

    public List<Alien> getHorde() {
        return horde;
    }

    public void removeDeadOnes(List<Mag> shots) {

    }

    public String toString() {
        return "";
    }
}
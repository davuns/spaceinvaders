import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bullets {
    private List<Mag> mag;

    public Bullets() {
        mag = new ArrayList<Mag>();
    }

    public void add(Mag m) {
        mag.add(m);
    }

    public void drawAll(Graphics window) {
        for (Mag m : mag) {
            m.draw(window);
        }
    }

    public void moveAll() {
        for (Mag m : mag) {
            m.move("up");
        }
    }

    public void clean() {
        for (int i = 0; i < mag.size(); i += 1) {
            if (mag.get(i).getY() < 0) {
                mag.remove(i);
            }
        }
    }

    public List<Mag> getList() {
        return mag;
    }

    public void remove(Mag m) {
        mag.remove(m);
    }

    public String toString() {
        return Arrays.toString(mag.toArray());
    }
}
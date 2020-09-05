import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class EndlessHorde {
    private List<Alien> horde;
    private int size = 0;
    private int y = 0;
    private Score score;

    public EndlessHorde(int s) {
        horde = new ArrayList<Alien>();
        size = s;
        score = new Score();
    }

    public void add(Alien a) {
        horde.add(a);
    }

    public Alien get(int i) {
        return horde.get(i);
    }

    public void drawAll(Graphics window) {
        for (Alien a : horde) {
            a.draw(window);
        }
    }

    public void moveAll() {
        for (Alien a : horde) {
            if (a.getX() < 0 || a.getX() > 750) {
                a.setY(a.getY() + 50);
                a.setSpd(a.getSpd() * -1);
            }
            a.move("");
        }
    }

    public List<Alien> getHorde() {
        return horde;
    }

    public int removeDeadOnes(List<Mag> shots, int n) {
        for (int i = 0; i < shots.size(); i += 1)
            for (int j = 0; j < horde.size(); j += 1)
                try {
                    if (shots.get(i).Collide(horde.get(j))) {
                        shots.remove(i);
                        horde.remove(j);
                        size -= 1;
                        n += 1;
                        if (size == 0) {
                            return n;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        return n;
    }

    public void checkShipDeath(Ship ship, int n) {
        for (Alien alien : horde) {
            if (ship.Collide(alien)) {
                System.out.println("YOU LOSE!");
                System.out.println(score.death(n));
                System.exit(0);
            }
        }
    }

    public void remove(Alien a) {
        horde.remove(a);
    }
}
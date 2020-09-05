import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Space extends Canvas implements KeyListener, Runnable {
    private Ship ship;
    private EndlessHorde horde;
    private int i = 0;
    private int score = 0;
    private int hordet = 0;
    private Bullets shots;
    private int tick;
    private boolean[] keys;
    private BufferedImage back;
    private Power power;
    private boolean doesItCollide;
    private int temp_tick = 60;

    public Space() throws InterruptedException {
        setBackground(Color.black);
        keys = new boolean[5];
        ship = new Ship(400, 500, 35, 35, 2);
        horde = new EndlessHorde(4);
        power = new Power(0, 0, 35, 35, 2);
        shots = new Bullets();
        this.addKeyListener(this);
        new Thread(this).start();
        setVisible(true);
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        Graphics2D twoDGraph = (Graphics2D)window;
        if (back == null) {
            back = (BufferedImage)(createImage(getWidth(), getHeight()));
        }
        Graphics graphToBack = back.createGraphics();
        graphToBack.setColor(Color.black);
        graphToBack.fillRect(0,0,800,600);
        graphToBack.setColor(Color.white);
        graphToBack.drawString("Score: " + score, 720, 550);
        ship.draw(graphToBack);
        if (hordet == i) {
            horde.add(new Alien(0, 0, 35, 35, 2));
            i += 50;
        }
        if (hordet == 1000) {
            i += 50;
        }
        if (hordet >= 1000) {
            power.draw(graphToBack);
            power.moveDown();
        }
        horde.drawAll(graphToBack);
        horde.moveAll();
        shots.drawAll(graphToBack);
        tick += 1;
        hordet += 1;
        if(keys[0])
        {
            ship.move("left");
        }
        if (keys[1])
        {
            ship.move("right");
        }
        if (keys[2])
        {
            ship.move("up");
        }
        if (keys[3])
        {
            ship.move("down");
        }
        if (keys[4])
        {
            if (tick >= temp_tick) {
                shots.add(new Mag(ship.getX() + ship.getW() / 2 - 2, ship.getY(), 5));
                tick = 0;
            }
        }

        doesItCollide = power.collide(shots.getList(), graphToBack, power);
        if (doesItCollide) {
            temp_tick = 10;
        }
        shots.moveAll();
        score = horde.removeDeadOnes(shots.getList(), score);
        shots.clean();
        horde.checkShipDeath(ship, score);
        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            keys[0] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            keys[1] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            keys[2] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            keys[3] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            keys[4] = true;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            keys[0] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            keys[1] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            keys[2] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            keys[3] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            keys[4] = false;
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {

    }

    public void run() {
        try {
            while(true) {
                Thread.currentThread();
                Thread.sleep(5);
                repaint();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
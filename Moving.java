import java.awt.Color;
import java.awt.Graphics;

public abstract class Moving implements Move {
    private int xPos;
    private int yPos;
    private int width;
    private int height;

    public Moving() {
        this(10, 10, 10, 10);
    }

    public Moving(int x, int y) {
        this(x, y, 10, 10);
    }

    public Moving(int x, int y, int w, int h) {
        setPos(x, y);
        setW(w);
        setH(h);
    }

    public boolean Collide(Moving m) {
        if (partialCollision(this.getX(), this.getY() + this.getH() / 2, m)) {
            return true;
        }
        else if (partialCollision(this.getX() + this.getW(), this.getY() + this.getW() / 2, m)) {
            return true;
        }
        else if (partialCollision(this.getX() + this.getW() / 2, this.getY(), m)) {
            return true;
        }
        else if (partialCollision(this.getX() + this.getW() / 2, this.getY() + this.getH(), m)) {
            return true;
        }
        return false;
    }

    public boolean partialCollision(int pointX, int pointY, Moving m) {
        return pointX > m.getX() && pointX < m.getX() + m.getW() && pointY > m.getY() && pointY < m.getY() + m.getH();
    }

    public void setPos(int x, int y) {
        setX(x);
        setY(y);
    }

    public void setX(int x) {
        xPos = x;
    }

    public void setY(int y) {
        yPos = y;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public void setW(int w) {
        width = w;
    }

    public void setH(int h) {
        height = h;
    }

    public int getW() {
        return width;
    }

    public int getH() {
        return height;
    }

    public abstract void move(String direction);
    public abstract void draw(Graphics window);

    public String toString() {
        return getX() +" " + getY() + " " + getW() + " " + getH();
    }
}
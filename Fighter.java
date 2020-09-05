import javax.swing.JFrame;
import java.awt.Component;

public class Fighter extends JFrame {
    private static final int width = 800;
    private static final int height = 600;

    public Fighter() throws InterruptedException {
        super("fighter");
        setSize(width, height);

        Space game = new Space();
        ((Component)game).setFocusable(true);
        getContentPane().add(game);
        setVisible(true);
    }

    public static void main(String args[]) throws InterruptedException {
        Fighter run = new Fighter();
    }
}
import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel {

    private Game game;

    public GameWindow(Game game) {
        this.game = game;

        JFrame frame = new JFrame("Mountain Goat Game");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        g.setColor(new Color(180, 220, 255));
        g.fillRect(0, 0, getWidth(), getHeight());

        // Ground
        g.setColor(new Color(100, 200, 100));
        g.fillRect(0, 300, getWidth(), 100);

        // Goat
        g.setColor(Color.BLACK);
        g.fillRect((int) game.goat.getPositionX(), 
                   300 - (int) game.goat.getPositionY(), 
                   20, 20);

        // Mountain
        g.setColor(Color.DARK_GRAY);
        g.fillRect((int) game.mountain.getPositionX(), 260, 40, 40);

        // Eagle
        g.setColor(Color.RED);
        g.fillOval((int) game.eagle.getPositionX(), 
                   200 - (int) game.eagle.getPositionY(), 
                   20, 20);

        // Score
        g.setColor(Color.BLACK);
        g.drawString("Score: " + game.score, 20, 20);
    }
}

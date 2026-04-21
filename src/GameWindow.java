import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JPanel implements KeyListener {

    private Game game;

    public GameWindow(Game game) {
        this.game = game;

        JFrame frame = new JFrame("Mountain Goat Game");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.addKeyListener(this);
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // sky
        g.setColor(new Color(180, 220, 255));
        g.fillRect(0, 0, getWidth(), getHeight());

        // ground
        g.setColor(new Color(100, 200, 100));
        g.fillRect(0, 300, getWidth(), 100);

        // goat
        g.setColor(Color.BLACK);
        g.fillRect(game.goat.x, 300 - game.goat.y - 40, 40, 40);

        // mountain
        g.setColor(Color.DARK_GRAY);
        g.fillRect(game.mountain.x, 260, 40, 40);

        // eagle
        g.setColor(Color.RED);
        g.fillOval(game.eagle.x, 200 - game.eagle.y, 30, 30);

        // score
        g.setColor(Color.BLACK);
        g.drawString("Score: " + game.score, 20, 20);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            game.goat.jump();
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}

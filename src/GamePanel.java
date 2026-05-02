import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Timer timer;
    private Player player;
    private ArrayList<Obstacle> obstacles;
    private int score;
    private enum GameState { START, PLAYING, GAME_OVER }
    private GameState gameState;
    private String message = "";

    public GamePanel() {
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.CYAN);
        addKeyListener(this);
        setFocusable(true);

        initGame();
        timer = new Timer(20, this);
        timer.start();
    }

    private void initGame() {
        player = new Player(50, 300); // position at bottom left
        obstacles = new ArrayList<>();
        score = 0;
        gameState = GameState.START;
        spawnObstacle();
    }

    private void spawnObstacle() {
        // Randomly spawn eagle or mountain (cactus)
        int type = (int)(Math.random() * 2);
        Obstacle obstacle;
        if (type == 0) {
            // Eagle (flying obstacle)
            obstacle = new Obstacle(800, 250, "EAGLE");
        } else {
            // Mountain (stationary obstacle)
            obstacle = new Obstacle(800, 340, "MOUNTAIN");
        }
        obstacles.add(obstacle);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameState == GameState.PLAYING) {
            updateGame();
        }
        repaint();
    }

    private void updateGame() {
        player.update();

        // Move obstacles
        Iterator<Obstacle> iter = obstacles.iterator();
        while (iter.hasNext()) {
            Obstacle obs = iter.next();
            obs.update();
            if (obs.x + obs.width < 0) {
                iter.remove();
                score++;
                spawnObstacle();
            }
            // Check collision
            if (player.getBounds().intersects(obs.getBounds())) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        gameState = GameState.GAME_OVER;
        message = "Game Over! Score: " + score + ". Press ENTER to Restart.";
    }

    private void startGame() {
        initGame();
        gameState = GameState.PLAYING;
        message = "";
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (gameState == GameState.START) {
            g.setFont(new Font("Arial", Font.BOLD, 24));
            g.drawString("Press ENTER to Start", 300, 200);
        } else {
            // Draw ground
            g.setColor(Color.GREEN.darker());
            g.fillRect(0, 380, 800, 20);
            // Draw player
            player.draw(g);
            // Draw obstacles
            for (Obstacle obs : obstacles) {
                obs.draw(g);
            }
            // Draw score
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Score: " + score, 10, 20);
            // Draw game over message
            if (gameState == GameState.GAME_OVER) {
                g.setFont(new Font("Arial", Font.BOLD, 24));
                g.drawString(message, 150, 200);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameState == GameState.START && e.getKeyCode() == KeyEvent.VK_ENTER) {
            startGame();
        } else if (gameState == GameState.PLAYING) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                player.jump();
            }
        } else if (gameState == GameState.GAME_OVER && e.getKeyCode() == KeyEvent.VK_ENTER) {
            startGame();
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}

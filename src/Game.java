import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JPanel implements Runnable {

    int score = 0;

    boolean isRunning = false;
    boolean hasStarted = false;

    Thread gameThread;

    Goat player;
    ArrayList<Mountain> mountains;
    ArrayList<Eagle> eagles;

    CollisionManager collisionManager;
    InputHandler input;

    public Game() {
        initGame();
        setFocusable(true);
    }

    public void initGame() {
        player = new Goat();
        mountains = new ArrayList<>();
        eagles = new ArrayList<>();
        collisionManager = new CollisionManager();

        input = new InputHandler(this);
        addKeyListener(input);
    }

    public void start() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void reset() {
        score = 0;
        mountains.clear();
        eagles.clear();
        player = new Goat();
        isRunning = true;
    }

    public void update() {
        if (!isRunning) return;

        player.update();

        if (Math.random() < 0.02) {
            mountains.add(new Mountain(800));
        }

        if (Math.random() < 0.01) {
            eagles.add(new Eagle(800));
        }

        mountains.forEach(Mountain::update);
        eagles.forEach(Eagle::update);

        for (Mountain m : mountains) {
            if (collisionManager.checkCollision(player, m)) {
                isRunning = false;
            }
        }

        for (Eagle e : eagles) {
            if (collisionManager.checkCollision(player, e)) {
                isRunning = false;
            }
        }

        score++;
    }

    @Override
    public void run() {
        while (true) {
            update();
            repaint();

            try {
                Thread.sleep(16);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        g.setColor(new Color(135, 206, 235)); // sky
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 350, getWidth(), 50); // ground

        if (!hasStarted) {
            g.setColor(Color.BLACK);
            g.drawString("MOUNTAIN RUNNER", 320, 150);
            g.drawString("Press SPACE to Start", 310, 200);
            return;
        }

        player.draw(g);

        for (Mountain m : mountains) {
            m.draw(g);
        }

        for (Eagle e : eagles) {
            e.draw(g);
        }

        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 20, 20);

        if (!isRunning) {
            g.drawString("GAME OVER - Press R to Restart", 260, 200);
        }
    }
}

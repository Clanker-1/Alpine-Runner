import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.*;

public class Game extends JPanel implements Runnable {

    int score = 0;
    int highScore = 0;

    boolean isRunning = false;
    boolean hasStarted = false;

    Thread gameThread;

    Goat player;
    ArrayList<Mountain> mountains;
    ArrayList<Eagle> eagles;

    CollisionManager collisionManager;
    InputHandler input;

    int gameSpeed = 5;
    int spawnTimer = 0;

    public Game() {
        initGame();
        loadHighScore();
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
        isRunning = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void reset() {
        score = 0;
        gameSpeed = 5;
        spawnTimer = 0;

        mountains.clear();
        eagles.clear();

        player = new Goat();
        isRunning = true;
    }

    public void update() {
        if (!isRunning) return;

        player.update();

        // difficulty scaling
        if (score % 500 == 0 && score != 0) {
            gameSpeed++;
        }

        spawnTimer++;

        // spawn system (balanced)
        if (spawnTimer > 70) {

            mountains.add(new Mountain(800, gameSpeed));

            if (Math.random() < 0.5) {
                eagles.add(new Eagle(800, gameSpeed));
            }

            spawnTimer = 0;
        }

        for (Mountain m : mountains) m.update();
        for (Eagle e : eagles) e.update();

        mountains.removeIf(m -> m.positionX < -100);
        eagles.removeIf(e -> e.positionX < -100);

        for (Mountain m : mountains) {
            if (collisionManager.checkCollision(player, m)) {
                gameOver();
            }
        }

        for (Eagle e : eagles) {
            if (collisionManager.checkCollision(player, e)) {
                gameOver();
            }
        }

        score++;
    }

    public void gameOver() {
        isRunning = false;

        if (score > highScore) {
            highScore = score;
            saveHighScore();
        }
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

        g.setColor(new Color(135, 206, 235));
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 330, getWidth(), 70);

        if (!hasStarted) {
            g.setColor(Color.BLACK);
            g.drawString("MOUNTAIN RUNNER", 320, 150);
            g.drawString("Press SPACE to Start", 300, 200);
            return;
        }

        player.draw(g);

        for (Mountain m : mountains) m.draw(g);
        for (Eagle e : eagles) e.draw(g);

        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 20, 20);
        g.drawString("High Score: " + highScore, 600, 20);

        if (!isRunning) {
            g.drawString("GAME OVER - Press R", 300, 200);
        }
    }

    // HIGH SCORE SAVE/LOAD
    public void loadHighScore() {
        try {
            File file = new File("highscore.txt");
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                highScore = Integer.parseInt(br.readLine());
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveHighScore() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("highscore.txt"));
            bw.write(String.valueOf(highScore));
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

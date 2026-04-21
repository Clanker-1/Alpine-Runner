public class Game {

    public Goat goat;
    public Mountain mountain;
    public Eagle eagle;

    public int score = 0;
    public boolean running = true;

    private GameWindow window;

    public Game() {
        goat = new Goat(100, 0);          // goat stays in place horizontally
        mountain = new Mountain(800, 300);
        eagle = new Eagle(900, 200);

        window = new GameWindow(this);
    }

    public void start() {
        long lastTime = System.nanoTime();
        double nsPerUpdate = 1_000_000_000.0 / 60.0; // 60 FPS

        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerUpdate;
            lastTime = now;

            while (delta >= 1) {
                update();
                delta--;
            }

            window.repaint();

            try {
                Thread.sleep(5);
            } catch (Exception e) {}
        }

        System.out.println("Game Over! Score: " + score);
    }

    public void update() {
        goat.update();
        mountain.update();
        eagle.update();

        score++;

        if (CollisionManager.hitMountain(goat, mountain) ||
            CollisionManager.hitEagle(goat, eagle)) {
            running = false;
        }
    }
}

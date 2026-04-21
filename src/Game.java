public class Game {

    public int score;
    public boolean isRunning;

    public Goat goat;
    public Mountain mountain;
    public Eagle eagle;

    private InputHandler inputHandler;
    private CollisionManager collisionManager;

    private GameWindow window;

    public Game() {
        this.score = 0;
        this.isRunning = false;

        this.goat = new Goat(50, 0);
        this.mountain = new Mountain(600, 40);
        this.eagle = new Eagle(700, 80);

        this.inputHandler = new InputHandler();
        this.collisionManager = new CollisionManager();

        this.window = new GameWindow(this);
    }

    public void start() {
        isRunning = true;

        while (isRunning) {
            update();
            window.repaint();

            try {
                Thread.sleep(30);
            } catch (Exception e) {}
        }

        System.out.println("Game Over! Score: " + score);
    }

    public void update() {
        inputHandler.listenForJump(goat);

        goat.update();
        mountain.update();
        eagle.update();

        if (collisionManager.checkCollision(goat, mountain) ||
            collisionManager.checkEnemyCollision(goat, eagle)) {
            isRunning = false;
        }

        score++;
    }
}

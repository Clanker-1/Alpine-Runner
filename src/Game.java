public class Game {

    private int score;
    private boolean isRunning;

    private Goat goat;
    private Mountain mountain;
    private Eagle eagle;

    private InputHandler inputHandler;
    private Render render;
    private CollisionManager collisionManager;

    public Game() {
        this.score = 0;
        this.isRunning = false;

        this.goat = new Goat(0, 0);
        this.mountain = new Mountain(20, 5);
        this.eagle = new Eagle(35, 4);

        this.inputHandler = new InputHandler();
        this.render = new Render();
        this.collisionManager = new CollisionManager();
    }

    public void start() {
        isRunning = true;
        System.out.println("Game started!");

        while (isRunning) {
            update();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Game over! Final score: " + score);
    }

    public void update() {
        inputHandler.listenForJump(goat);

        goat.update();
        mountain.update();
        eagle.update();

        if (collisionManager.checkCollision(goat, mountain) ||
            collisionManager.checkEnemyCollision(goat, eagle)) {
            isRunning = false;
            return;
        }

        score++;

        render.renderGoat(goat);
        render.renderMountain(mountain);
        render.renderEagle(eagle);
        render.renderScore(score);

        System.out.println("------------------------");
    }
}

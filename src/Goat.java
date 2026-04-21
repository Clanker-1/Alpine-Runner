public class Goat {

    public int x;
    public int y;
    private double velocityY = 0;

    private final double GRAVITY = -0.6;
    private final double JUMP_FORCE = 12;

    public Goat(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void jump() {
        if (y == 0) {
            velocityY = JUMP_FORCE;
        }
    }

    public void update() {
        velocityY += GRAVITY;
        y += velocityY;

        if (y < 0) {
            y = 0;
            velocityY = 0;
        }
    }
}

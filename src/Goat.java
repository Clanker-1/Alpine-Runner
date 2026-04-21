public class Goat {

    private float positionX;
    private float positionY;
    private float velocityY;
    private boolean isJumping;

    private final float GRAVITY = -0.5f;
    private final float JUMP_STRENGTH = 5f;

    public Goat(float startX, float startY) {
        this.positionX = startX;
        this.positionY = startY;
        this.velocityY = 0;
        this.isJumping = false;
    }

    public void jump() {
        if (!isJumping) {
            velocityY = JUMP_STRENGTH;
            isJumping = true;
        }
    }

    public void update() {
        positionX += 0.5f;

        velocityY += GRAVITY;
        positionY += velocityY;

        if (positionY <= 0) {
            positionY = 0;
            velocityY = 0;
            isJumping = false;
        }
    }

    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }
}

public class Eagle {

    private float positionX;
    private float positionY;

    public Eagle(float startX, float startY) {
        this.positionX = startX;
        this.positionY = startY;
    }

    public void update() {
        positionX -= 1.0f;

        if (positionX < -5) {
            positionX = 40;
            positionY = 3 + (float)(Math.random() * 5);
        }
    }

    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }
}

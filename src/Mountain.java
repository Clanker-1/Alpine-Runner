public class Mountain {

    private float positionX;
    private float width;

    public Mountain(float startX, float width) {
        this.positionX = startX;
        this.width = width;
    }

    public void update() {
        positionX -= 0.7f;

        if (positionX < -5) {
            positionX = 30;
        }
    }

    public float getPositionX() {
        return positionX;
    }

    public float getWidth() {
        return width;
    }
}

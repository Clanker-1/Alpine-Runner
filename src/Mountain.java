public class Mountain {

    public int x;
    public int y;

    public Mountain(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        x -= 8;

        if (x < -50) {
            x = 850;
        }
    }
}

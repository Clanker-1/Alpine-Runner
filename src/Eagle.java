public class Eagle {

    public int x;
    public int y;

    public Eagle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        x -= 10;

        if (x < -50) {
            x = 900;
            y = 100 + (int)(Math.random() * 80);
        }
    }
}

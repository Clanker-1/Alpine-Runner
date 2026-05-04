import java.awt.*;

public class Mountain {

    float positionX;
    int speed;

    public Mountain(float x, int speed) {
        this.positionX = x;
        this.speed = speed;
    }

    public void update() {
        positionX -= speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GRAY);

        int[] x = {(int) positionX, (int) positionX + 20, (int) positionX + 40};
        int[] y = {330, 280, 330};

        g.fillPolygon(x, y, 3);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) positionX + 10, 290, 20, 40);
    }
}

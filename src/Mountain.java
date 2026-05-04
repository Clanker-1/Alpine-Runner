import java.awt.*;

public class Mountain {

    float positionX;
    int speed;

    public Mountain(float startX, int speed) {
        this.positionX = startX;
        this.speed = speed;
    }

    public void update() {
        positionX -= speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GRAY);

        int[] xPoints = {(int) positionX, (int) positionX + 20, (int) positionX + 40};
        int[] yPoints = {330, 280, 330};

        g.fillPolygon(xPoints, yPoints, 3);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) positionX, 280, 40, 50);
    }
}

import java.awt.*;

public class Mountain {

    float positionX;

    public Mountain(float startX) {
        this.positionX = startX;
    }

    public void update() {
        positionX -= 5;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GRAY);

        int[] xPoints = {(int) positionX, (int) positionX + 20, (int) positionX + 40};
        int[] yPoints = {350, 300, 350};

        g.fillPolygon(xPoints, yPoints, 3);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) positionX, 300, 40, 50);
    }
}

import java.awt.*;

public class Eagle {

    float positionX;
    float positionY = 230;
    int speed;

    public Eagle(float startX, int speed) {
        this.positionX = startX;
        this.speed = speed + 2;
    }

    public void update() {
        positionX -= speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);

        g.fillOval((int) positionX, (int) positionY, 25, 15);

        g.drawLine((int) positionX, (int) positionY,
                (int) positionX - 10, (int) positionY - 10);

        g.drawLine((int) positionX + 25, (int) positionY,
                (int) positionX + 35, (int) positionY - 10);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) positionX, (int) positionY, 30, 20);
    }
}

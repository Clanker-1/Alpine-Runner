import java.awt.*;

public class Eagle {

    float positionX;
    float positionY = 230;
    int speed;

    int flapFrame = 0;
    int flapCounter = 0;

    public Eagle(float startX, int speed) {
        this.positionX = startX;
        this.speed = speed + 2;
    }

    public void update() {
        positionX -= speed;

        // animation
        flapCounter++;
        if (flapCounter > 8) {
            flapFrame = (flapFrame + 1) % 2;
            flapCounter = 0;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);

        // body
        g.fillOval((int) positionX, (int) positionY, 25, 15);

        // wings
        if (flapFrame == 0) {
            g.drawLine((int) positionX, (int) positionY,
                       (int) positionX - 10, (int) positionY - 10);

            g.drawLine((int) positionX + 25, (int) positionY,
                       (int) positionX + 35, (int) positionY - 10);
        } else {
            g.drawLine((int) positionX, (int) positionY,
                       (int) positionX - 10, (int) positionY + 5);

            g.drawLine((int) positionX + 25, (int) positionY,
                       (int) positionX + 35, (int) positionY + 5);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int) positionX + 5, (int) positionY + 5, 20, 10);
    }
}

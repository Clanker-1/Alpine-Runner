import java.awt.*;

public class Eagle {

    float positionX;
    float positionY = 230;
    int speed;

    int frame = 0;
    int counter = 0;

    public Eagle(float x, int speed) {
        this.positionX = x;
        this.speed = speed + 2;
    }

    public void update() {
        positionX -= speed;

        counter++;
        if (counter > 8) {
            frame = (frame + 1) % 2;
            counter = 0;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);

        g.fillOval((int) positionX, (int) positionY, 25, 15);

        if (frame == 0) {
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

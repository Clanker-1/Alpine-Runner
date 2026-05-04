import java.awt.*;

public class Goat {

    float positionX = 50;
    float positionY = 300;
    float velocityY = 0;

    final int GROUND_Y = 300;

    boolean isJumping = false;

    public void jump() {
        if (!isJumping) {
            velocityY = -12;
            isJumping = true;
        }
    }

    public void update() {
        velocityY += 0.8; // stronger gravity
        positionY += velocityY;

        // snap EXACTLY to ground
        if (positionY >= GROUND_Y) {
            positionY = GROUND_Y;
            velocityY = 0;
            isJumping = false;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int) positionX, (int) positionY, 30, 20);

        g.fillOval((int) positionX + 20, (int) positionY - 10, 15, 15);

        g.setColor(Color.BLACK);
        g.drawLine((int) positionX + 5, (int) positionY + 20, (int) positionX + 5, (int) positionY + 30);
        g.drawLine((int) positionX + 20, (int) positionY + 20, (int) positionX + 20, (int) positionY + 30);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) positionX, (int) positionY, 30, 30);
    }
}

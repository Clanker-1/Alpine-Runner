import java.awt.*;

public class Goat {

    float positionX = 50;
    float positionY = 300;
    float velocityY = 0;

    final int GROUND_Y = 300;

    boolean isJumping = false;

    int animationFrame = 0;
    int animationCounter = 0;

    public void jump() {
        if (!isJumping) {
            velocityY = -12;
            isJumping = true;
        }
    }

    public void update() {
        velocityY += 0.8;
        positionY += velocityY;

        if (positionY >= GROUND_Y) {
            positionY = GROUND_Y;
            velocityY = 0;
            isJumping = false;
        }

        // animation
        animationCounter++;
        if (animationCounter > 10) {
            animationFrame = (animationFrame + 1) % 2;
            animationCounter = 0;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);

        // body
        g.fillRect((int) positionX, (int) positionY, 30, 20);

        // head
        g.fillOval((int) positionX + 20, (int) positionY - 10, 15, 15);

        g.setColor(Color.BLACK);

        // animated legs
        if (animationFrame == 0) {
            g.drawLine((int) positionX + 5, (int) positionY + 20,
                       (int) positionX + 5, (int) positionY + 30);

            g.drawLine((int) positionX + 20, (int) positionY + 20,
                       (int) positionX + 20, (int) positionY + 30);
        } else {
            g.drawLine((int) positionX + 5, (int) positionY + 20,
                       (int) positionX + 10, (int) positionY + 30);

            g.drawLine((int) positionX + 20, (int) positionY + 20,
                       (int) positionX + 15, (int) positionY + 30);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int) positionX + 5, (int) positionY + 5, 20, 20);
    }
}

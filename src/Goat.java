import java.awt.*;

public class Goat {

    float positionX = 50;
    float positionY = 300;
    float velocityY = 0;

    boolean isJumping = false;

    public void jump() {
        if (!isJumping) {
            velocityY = -12;
            isJumping = true;
        }
    }

    public void update() {
        velocityY += 0.6;
        positionY += velocityY;

        if (positionY >= 300) {
            positionY = 300;
            isJumping = false;
        }
    }

    public void draw(Graphics g) {
        // body
        g.setColor(Color.WHITE);
        g.fillRect((int) positionX, (int) positionY, 30, 20);

        // head
        g.fillOval((int) positionX + 20, (int) positionY - 10, 15, 15);

        // legs
        g.setColor(Color.BLACK);
        g.drawLine((int) positionX + 5, (int) positionY + 20, (int) positionX + 5, (int) positionY + 30);
        g.drawLine((int) positionX + 20, (int) positionY + 20, (int) positionX + 20, (int) positionY + 30);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) positionX, (int) positionY, 30, 30);
    }
}

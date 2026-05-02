import java.awt.*;

public class Player {
    int x, y;
    int width = 40;
    int height = 40;
    int yVelocity = 0;
    boolean isJumping = false;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        if (isJumping) {
            y -= yVelocity;
            yVelocity -= 1;
            if (y >= 360) {
                y = 360;
                isJumping = false;
            }
        }
    }

    public void jump() {
        if (!isJumping) {
            isJumping = true;
            yVelocity = 15;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
        // You can replace the rectangle with an image of a mountain goat
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}

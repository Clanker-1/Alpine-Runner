import java.awt.*;

public class Obstacle {
    int x, y;
    int width = 20;
    int height;
    String type;

    public Obstacle(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
        if (type.equals("EAGLE")) {
            this.height = 20; // Flying obstacle
        } else {
            this.height = 40; // Mountain/cactus
        }
    }

    public void update() {
        x -= 10; // speed
    }

    public void draw(Graphics g) {
        if (type.equals("EAGLE")) {
            g.setColor(Color.GRAY);
            g.fillOval(x, y, width, height);
        } else {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(x, y, width, height);
        }
        // Replace with images if desired
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}

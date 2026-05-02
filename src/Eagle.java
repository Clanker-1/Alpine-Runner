import java.awt.*;

public class Eagle {

    float positionX;
    float positionY = 250;

    public Eagle(float startX) {
        this.positionX = startX;
    }

    public void update() {
        positionX -= 7;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);

        // body
        g.fillOval((int) positionX, (int) positionY, 25, 15);

        // wings
        g.drawLine((int) positionX, (int) positionY,
                (int) positionX - 10, (int) positionY - 10);

        g.drawLine((int) positionX + 25, (int) positionY,
                (int) positionX + 35, (int) positionY - 10);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) positionX, (int) positionY, 30, 20);
    }
}

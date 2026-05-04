public class CollisionManager {

    public boolean checkCollision(Goat g, Mountain m) {
        return g.getBounds().intersects(m.getBounds());
    }

    public boolean checkCollision(Goat g, Eagle e) {
        return g.getBounds().intersects(e.getBounds());
    }
}

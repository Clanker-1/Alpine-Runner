public class CollisionManager {

    public boolean checkCollision(Goat player, Mountain obstacle) {
        return player.getBounds().intersects(obstacle.getBounds());
    }

    public boolean checkCollision(Goat player, Eagle enemy) {
        return player.getBounds().intersects(enemy.getBounds());
    }
}

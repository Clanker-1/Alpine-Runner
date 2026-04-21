public class CollisionManager {

    public boolean checkCollision(Goat goat, Mountain mountain) {
        return Math.abs(goat.getPositionX() - mountain.getPositionX()) < 1 &&
               goat.getPositionY() <= 0.1;
    }

    public boolean checkEnemyCollision(Goat goat, Eagle eagle) {
        return Math.abs(goat.getPositionX() - eagle.getPositionX()) < 1 &&
               Math.abs(goat.getPositionY() - eagle.getPositionY()) < 1;
    }
}

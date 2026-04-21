public class Render {

    public void renderGoat(Goat goat) {
        System.out.println("Goat at (" + goat.getPositionX() + ", " + goat.getPositionY() + ")");
    }

    public void renderMountain(Mountain mountain) {
        System.out.println("Mountain at x=" + mountain.getPositionX());
    }

    public void renderEagle(Eagle eagle) {
        System.out.println("Eagle at (" + eagle.getPositionX() + ", " + eagle.getPositionY() + ")");
    }

    public void renderScore(int score) {
        System.out.println("Score: " + score);
    }
}

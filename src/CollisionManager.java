public class CollisionManager {

    public static boolean hitMountain(Goat g, Mountain m) {
        return g.x + 40 > m.x && g.x < m.x + 40 &&
               300 - g.y - 40 < 260 + 40;
    }

    public static boolean hitEagle(Goat g, Eagle e) {
        return g.x + 40 > e.x && g.x < e.x + 30 &&
               300 - g.y - 40 < 200 - e.y + 30;
    }
}

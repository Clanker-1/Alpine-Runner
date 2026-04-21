public class InputHandler {

    private int tick = 0;

    public void listenForJump(Goat goat) {
        tick++;

        // Auto jump every 10 ticks for demo
        if (tick % 10 == 0) {
            goat.jump();
        }
    }
}

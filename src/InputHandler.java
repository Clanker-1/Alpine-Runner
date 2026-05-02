import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {

    Game game;

    public InputHandler(Game game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            if (!game.hasStarted) {
                game.hasStarted = true;
                game.isRunning = true;
            } else {
                game.player.jump();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_R) {
            game.reset();
        }
    }
}

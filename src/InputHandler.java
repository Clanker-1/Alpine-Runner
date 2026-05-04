import java.awt.event.*;

public class InputHandler extends KeyAdapter {

    Game game;

    public InputHandler(Game game) {
        this.game = game;
    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            game.hasStarted = true;
            game.isRunning = true;
            game.player.jump();
        }

        if (e.getKeyCode() == KeyEvent.VK_R) {
            game.reset();
        }
    }
}

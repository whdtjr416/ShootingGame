package game.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import game.main.GamePanel;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                gamePanel.getPlayer().setLeft(false);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.getPlayer().setRight(false);
                break;
            case KeyEvent.VK_UP:
                gamePanel.getPlayer().setUp(false);
                break;
            case KeyEvent.VK_DOWN:
                gamePanel.getPlayer().setDown(false);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                gamePanel.getPlayer().setLeft(true);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.getPlayer().setRight(true);
                break;
            case KeyEvent.VK_UP:
                gamePanel.getPlayer().setUp(true);
                break;
            case KeyEvent.VK_DOWN:
                gamePanel.getPlayer().setDown(true);
                break;
        }
    }
}

package game.main;

import javax.swing.JFrame;

public class GameWindow {
    private JFrame jframe;
    private GamePanel gamePanel;

    public GameWindow() {
        jframe = new JFrame("Shooting Game");
        gamePanel = new GamePanel();
        
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setLocationRelativeTo(null);  // pack() 후에 위치를 설정
        jframe.setVisible(true);
    }
}

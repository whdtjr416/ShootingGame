package game.main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        Game game = new Game();
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(game.getGamePanel());
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}

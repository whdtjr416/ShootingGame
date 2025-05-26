package game.main;

import game.entities.Enemy;
import game.entities.Player;
import game.inputs.KeyboardInputs;
import game.inputs.MouseInputs;
import game.utils.Constants;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel {
    private Player player;
    private ArrayList<Enemy> enemies;
    private Random random;
    private long lastEnemySpawnTime;
    private int spawnInterval = 100; // 0.1초마다 적 생성으로 변경
    private int maxEnemies = 70; // 최대 적 수 제한
    private int score = 0;

    public GamePanel() {
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(new MouseInputs(this));
        setFocusable(true);
        
        initializeGame();
    }

    private void initializeGame() {
        player = new Player(Constants.GAME_WIDTH / 2 - 20, Constants.GAME_HEIGHT - 100);
        enemies = new ArrayList<>();
        random = new Random();
        lastEnemySpawnTime = System.currentTimeMillis();
    }

    private void setPanelSize() {
        Dimension size = new Dimension(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        setPreferredSize(size);
    }

    public void updateGame() {
        if (player != null) {
            player.update();
            
            // 적 생성 로직
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastEnemySpawnTime >= spawnInterval) {
                spawnEnemy();
                lastEnemySpawnTime = currentTime;
            }
            

            // 적 업데이트 및 충돌 검사
            for (int i = enemies.size() - 1; i >= 0; i--) {
                Enemy enemy = enemies.get(i);
                enemy.update();

                // 화면 밖으로 나간 적 제거 및 점수 증가
                if (!enemy.isActive()) {
                    enemies.remove(i);
                    if (enemy.getY() > Constants.GAME_HEIGHT) {
                        score += 10;
                    }
                    continue;
                }

                // 충돌 검사
                if (enemy.getHitbox().intersects(player.getHitbox())) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        // 게임 오버 시 초기화
        score = 0;
        enemies.clear();
        player.resetPosition(); // 플레이어 위치 초기화
    }

    private void spawnEnemy() {
        // 현재 적의 수가 최대치보다 적을 때만 새로운 적 생성
        if (enemies.size() < maxEnemies) {
            float x = random.nextFloat() * (Constants.GAME_WIDTH - 20);
            Enemy enemy = new Enemy(x, -20);
            // 랜덤한 속도로 적 생성
            enemy.setSpeed(2 + random.nextFloat() * 3); // 2~5 사이의 랜덤한 속도
            enemies.add(enemy);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);

        // 게임 요소 렌더링
        if (player != null) {
            player.render(g);
            for (Enemy enemy : enemies) {
                enemy.render(g);
            }

            // 점수 표시
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Score: " + score, 10, 30);
        }
    }

    public Player getPlayer() {
        return player;
    }
}

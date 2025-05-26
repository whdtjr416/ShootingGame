package game.entities;

import game.utils.Constants;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Polygon;

public class Player {
    private float x, y;
    private int width = 40;
    private int height = 40;
    private float speed = 5.0f;
    private boolean left, right, up, down;
    private Rectangle hitbox;
    private Color goldColor = new Color(255, 215, 0); // 금색

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
        this.hitbox = new Rectangle((int)x, (int)y, width, height);
    }

    public void render(Graphics g) {
        // 비행기 본체 (삼각형)
        int[] xPoints = {
            (int)x + width/2,        // 앞부분 끝
            (int)x,                  // 왼쪽 뒷부분
            (int)x + width           // 오른쪽 뒷부분
        };
        
        int[] yPoints = {
            (int)y,                  // 앞부분 끝
            (int)y + height,         // 왼쪽 뒷부분
            (int)y + height          // 오른쪽 뒷부분
        };

        // 비행기 본체 그리기
        g.setColor(goldColor);
        g.fillPolygon(xPoints, yPoints, 3);

        // 날개 그리기
        int wingWidth = width/3;
        
        // 왼쪽 날개
        int[] leftWingX = {
            (int)x + width/4,
            (int)x - wingWidth,
            (int)x + width/4
        };
        int[] leftWingY = {
            (int)y + height/2,
            (int)y + height*2/3,
            (int)y + height*3/4
        };
        g.fillPolygon(leftWingX, leftWingY, 3);

        // 오른쪽 날개
        int[] rightWingX = {
            (int)x + width*3/4,
            (int)x + width + wingWidth,
            (int)x + width*3/4
        };
        int[] rightWingY = {
            (int)y + height/2,
            (int)y + height*2/3,
            (int)y + height*3/4
        };
        g.fillPolygon(rightWingX, rightWingY, 3);

        // 조종석 표시
        g.setColor(new Color(255, 240, 150)); // 밝은 금색
        g.fillOval((int)(x + width/3), (int)(y + height/3), width/3, height/3);
    }

    // 나머지 메소드들은 동일...
    public void update() {
        if (left && x > 0) {
            x -= speed;
        }
        if (right && x < Constants.GAME_WIDTH - width) {
            x += speed;
        }
        if (up && y > 0) {
            y -= speed;
        }
        if (down && y < Constants.GAME_HEIGHT - height) {
            y += speed;
        }
        updateHitbox();
    }

    private void updateHitbox() {
        hitbox.x = (int)x;
        hitbox.y = (int)y;
    }

    public void resetPosition() {
        x = Constants.GAME_WIDTH / 2 - width / 2;
        y = Constants.GAME_HEIGHT - 100;
        updateHitbox();
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
}

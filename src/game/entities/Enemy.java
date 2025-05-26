package game.entities;

import game.utils.Constants;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class Enemy {
    private float x, y;
    private int width = 20;
    private int height = 20;
    private float speed = 3.0f;
    private Rectangle hitbox;
    private boolean active = true;

    public Enemy(float x, float y) {
        this.x = x;
        this.y = y;
        this.hitbox = new Rectangle((int)x, (int)y, width, height);
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void update() {
        y += speed;
        if (y > Constants.GAME_HEIGHT) {
            active = false;
        }
        updateHitbox();
    }

    private void updateHitbox() {
        hitbox.x = (int)x;
        hitbox.y = (int)y;
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, width, height);
    }

    public boolean isActive() {
        return active;
    }

    public float getY() {
        return y;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
}

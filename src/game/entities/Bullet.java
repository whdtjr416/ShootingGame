package game.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Entity {
    private float speed = -10f;  // Negative because moving upwards

    public Bullet(float x, float y) {
        super(x, y, 4, 10);
    }

    @Override
    public void update() {
        y += speed;
        updateHitbox();
        
        if (y + height < 0) {
            setActive(false);
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, width, height);
    }
}

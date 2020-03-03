package rpg.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Projectile {
    private Rival rival;
    private TextureRegion textureRegion;
    private Vector2 position;
    private Vector2 velocity;
    private boolean active;
    private boolean target;
    private float speed;

    public Projectile(TextureAtlas imGame) {
        this.rival = new Rival(imGame);
        this.textureRegion = imGame.findRegion("ball");
        this.position = new Vector2(0, 0);
        this.velocity = new Vector2(0, 0);
        this.speed = 800.0f;
        this.active = false;
    }

    public float getSpeed(){
        return speed;
    }

    public Vector2 getPosition(){
        return position;
    }

    public void setup(float x, float y, float targetX, float targetY) {
        if (!active) {
            position.set(x, y);
            velocity.set(targetX, targetY).sub(x, y).nor().scl(speed);
            active = true;
        }
    }

    public void deactivate() {
        active = false;
    }

    public void render(SpriteBatch batch) {
        if (active) {
            batch.draw(textureRegion, position.x - 30, position.y - 30, 30, 30,
                    60, 60, 1, 1, velocity.angle());
        }
        rival.render(batch);
    }

    public void update(float dt) {
        if (active) {
            rival.update(dt,position.x,position.y);
            position.mulAdd(velocity, dt);
            if (position.x < 0 || position.x > 1280 || position.y < 0 || position.y > 720 || rival.isTarget()) {
                deactivate();
            }
        }
    }
}
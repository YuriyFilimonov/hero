package rpg.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Hero {
    private Texture texture;
    private Vector2 position;
    private float speed;

    public Hero() {
        this.texture = new Texture("footballer.png");
        this.position = new Vector2(0, 0);
        speed = 100.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, 75.0f, 75.0f, 150.0f,
                150.0f, 1.0f, 1.0f, 0.0f, 0, 300, 150, 150,
                true, false);
//        batch.draw(texture, position.x, position.y);
    }

    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            position.x -= speed * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            position.x += speed * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            position.y += speed * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            position.y -= speed * dt;
        }
    }
}

package rpg.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Pangolin {
    private Texture texture;
    private Vector2 position;
    private int viewY;
    private float pointRotate;

    public Pangolin() {
        this.texture = new Texture("pangolin.png");
        this.position = new Vector2(1230, 670);
        viewY = 300;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - 50, position.y - 50, 50.0f, 50.0f, 150.0f,
                150.0f, 1.0f, 1.0f, 0.0f, 0, viewY, 100, 100,
                true, false);
//        batch.draw(texture, position.x, position.y);
    }

    public void update(float dt) {
        pointRotate += dt;
        if (pointRotate > 0.1f) {
            viewY += 100;
            pointRotate = 0.0f;
        }
        if (viewY > 700) viewY = 0;

        if (Gdx.input.justTouched()) {
            position.set(Gdx.input.getX(), 720 - Gdx.input.getY());
        }

//        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
//            position.x -= speed * dt;
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
//            position.x += speed * dt;
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
//            position.y += speed * dt;
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
//            position.y -= speed * dt;
//        }
    }

}

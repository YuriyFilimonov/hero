package rpg.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Rival {
    Random random;
    private TextureRegion texture;
    private Vector2 position;
    private int x;
    private int y;
    private boolean target;

    public Rival(TextureAtlas imGame) {
        random = new Random();
        this.texture = imGame.findRegion("rival");
        this.position = new Vector2();
        setup();
        target = false;
    }

    public void setup(){
        x = 32 + random.nextInt(1217);
        y = 32 + random.nextInt(657);
        position.set(x,y);
    }

    public boolean isTarget(){
        return target;
    }

    public void render(SpriteBatch batch) {
            batch.draw(texture, x - 32, y - 32, 32, 32, 64, 64,
                    1, 1, 0);
    }

    public void update(float dt, float posX, float posY) {
        if (position.dst(posX,posY) < 30.0f){
            setup();
            target = true;
        } else target = false;
    }
}

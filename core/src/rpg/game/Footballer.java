package rpg.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Footballer {
    private Projectile projectile;
    private TextureRegion texture;
    private TextureRegion texturePointer;
    private TextureRegion textureHp;
    private Vector2 position;
    private Vector2 dst;
    private Vector2 tmp;
    private float lifetime;
    private float speed;
    private int hp;
    private int hpMax;
    private StringBuilder strBuilder;

    public Footballer(TextureAtlas imHero, TextureAtlas imGame) {
        this.texture = imHero.findRegion("footballer2-1");
        this.texturePointer = imGame.findRegion("target");
        this.textureHp = imGame.findRegion("hp");
        this.position = new Vector2(100, 100);
        this.projectile = new Projectile(imGame);
        this.dst = new Vector2(position);
        this.tmp = new Vector2(0, 0);
        this.speed = 300.0f;
        this.hpMax = 10;
        this.hp = 10;
        this.strBuilder = new StringBuilder();
    }

    public void render(SpriteBatch batch) {
        batch.draw(texturePointer, dst.x - 32, dst.y - 32, 32, 32, 64, 64,
                0.5f, 0.5f, lifetime * 90.0f);
        batch.draw(texture, position.x - 32, position.y - 64, 32, 64, 64, 128,
                1, 1, 0);
        batch.draw(textureHp, position.x - 32, position.y + 64, 64 * ((float) hp / hpMax), 8);
        projectile.render(batch);
    }

    public void renderGUI(SpriteBatch batch, BitmapFont font) {
        strBuilder.setLength(0);
        strBuilder.append("Class: ").append("Footballer").append("\n");
        strBuilder.append("HP: ").append(hp).append(" / ").append(hpMax).append("\n");
        font.draw(batch, strBuilder, 10, 710);
    }

    public void update(float dt) {
        projectile.update(dt);
        lifetime += dt;
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            dst.set(Gdx.input.getX(), 720.0f - Gdx.input.getY());
        }
        if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
            projectile.setup(position.x, position.y, Gdx.input.getX(), 720.0f - Gdx.input.getY());
        }
        tmp.set(dst).sub(position).nor().scl(speed); // вектор скорости
        if (position.dst(dst) > speed * dt) {
            position.mulAdd(tmp, dt);
        } else {
            position.set(dst);
        }
    }
}

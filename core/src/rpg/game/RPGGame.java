package rpg.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RPGGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private BitmapFont font32;
	private TextureAtlas imGame;
	private TextureRegion textureGrass;
	private TextureAtlas imHero;
	private Footballer footballer;

	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.imGame = new TextureAtlas("game.pack");
		this.imHero = new TextureAtlas("hero.pack");
		this.footballer = new Footballer(imHero, imGame);
		this.textureGrass = imGame.findRegion("grass");
		this.font32 = new BitmapFont(Gdx.files.internal("font32.fnt"));
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 12; j++) {
				batch.draw(textureGrass, i * 64, j * 64);
			}
		}
		footballer.render(batch);
		footballer.renderGUI(batch, font32);
		batch.end();
	}

	public void update(float dt) {
	    footballer.update(dt);
	}

@Override
	public void dispose () { batch.dispose(); }
}

package rpg.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RPGGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Hero hero;
	private Texture textureGrass;

	@Override
	public void create () {
		batch = new SpriteBatch();
		hero = new Hero();
		textureGrass = new Texture("grass.png");
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 16; j++) {
				batch.draw(textureGrass,j*80,i*80);
			}
		}
		hero.render(batch);
		batch.end();
	}

	public void update(float dt){
		hero.update(dt);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}

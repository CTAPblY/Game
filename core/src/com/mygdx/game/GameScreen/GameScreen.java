package com.mygdx.game.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Control.TargetController;
import com.mygdx.game.GameMenuScreen.GameMenuScreen;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.model.Target;
import java.util.Random;




public class GameScreen  implements Screen {

    public Texture targetTexture;
    public SpriteBatch batch;
    Target target;
    Target target1;
    Target target2;
    Target target3;
    Target target4;
    public MyGdxGame menu;
    public static float deltaCS;
    Texture fone;


    public GameScreen(MyGdxGame menu){this.menu = menu;}


    public static float generateRandomFloat(float min, float max){
        Random random = new Random();
        return random.nextFloat()*((max - min) + 1) + min;
    }

    @Override
    public void show() {
        fone = new Texture(Gdx.files.internal("Button/fone.jpg"));
        batch = new SpriteBatch();
        targetTexture = new Texture(Gdx.files.internal("target/Trump1.png"));
        target = new Target(targetTexture, generateRandomFloat(1, 830),generateRandomFloat(1, 830) ,1,1);
        target1 = new Target(targetTexture, generateRandomFloat(1, 830), generateRandomFloat(1, 830), 1, 1);
        target2 = new Target(targetTexture, generateRandomFloat(1, 830), generateRandomFloat(1, 830), 1, 1);
        target3 = new Target(targetTexture, generateRandomFloat(1, 830), generateRandomFloat(1, 830), 1, 1);
        target4 = new Target(targetTexture, generateRandomFloat(1, 830), generateRandomFloat(1, 830), 1, 1);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        deltaCS = delta;

        batch.begin();
        batch.draw(fone, 0,0);

        if (TargetController.fails > 6){
            menu.setScreen(new GameMenuScreen(menu));
            TargetController.fails = 0;
        }

        target.draw(batch);
        target1.draw(batch);
        target2.draw(batch);
        target3.draw(batch);
        target4.draw(batch);


        batch.end();
    }



    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

package com.mygdx.game.GameMenuScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameScreen.GameScreen;
import com.mygdx.game.MyGdxGame;

public class GameMenuScreen  implements Screen {

    public static final int Start_width = 200;
    public static final int Start_height = 200;
    public static final int Exit_height = 300;
    public static final int Exit_width = 300;
    private float changeY;

    Texture Inactive_start;
    Texture Active_start;
    Texture Inactive_exit;
    Texture Active_exit;
    SpriteBatch batch;
   public MyGdxGame gameScreen;



    public GameMenuScreen(MyGdxGame gameScreen){
        this.gameScreen = gameScreen;
    }


    @Override
    public void show() {
        Inactive_start = new Texture(Gdx.files.internal("Button/Inactive_start.png"));
        batch = new SpriteBatch();
        Active_start = new Texture(Gdx.files.internal("Button/Active_start.jpg"));
        Inactive_exit = new Texture(Gdx.files.internal("Button/Inactive_exit.png"));
        Active_exit = new Texture(Gdx.files.internal("Button/Active_exit.png"));
    }

    @Override
    public void render(float delta) {
        changeY = (Gdx.input.getY() - 900)*(-1);

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if (Gdx.input.getX() <= Start_width + 350 && Gdx.input.getX() >= 350 && changeY <= Start_height + 500 && changeY >= 500){
            batch.draw(Active_start,350,500);
            if (Gdx.input.isTouched()){
                gameScreen.setScreen(new GameScreen(gameScreen));
            }
        } else {
            batch.draw(Inactive_start, 350,500);
        }
        if (Gdx.input.getX() <= Exit_width + 300 && Gdx.input.getX() >= 300 && changeY <= Exit_height + 100 && changeY >= 100){
            batch.draw(Active_exit,300, 100);
            if (Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        } else{
            batch.draw(Inactive_exit, 300,100);
        }
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

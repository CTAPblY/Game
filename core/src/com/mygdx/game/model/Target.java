package com.mygdx.game.model;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Control.TargetController;


public class Target extends GameObject {

    private TargetController targetController;




    public Target(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        targetController = new TargetController(bounds);
    }




    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        targetController.handle();
        targetController.changeCoordinate();
    }



}

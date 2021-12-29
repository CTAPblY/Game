package com.mygdx.game.model;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;


 abstract class GameObject {

        Polygon bounds;
        Sprite object;



        public GameObject (Texture texture, float x, float y, float width, float height){
            bounds = new Polygon(new float[]{0f, 0f, width, 0f, width, height, 0f, height});
            object = new Sprite(texture);
            object.setSize(width, height);
            bounds.setPosition(x, y);
            object.setPosition(x, y);
            bounds.setScale(width, height);

        }



        public void draw(SpriteBatch batch){
                object.setSize(bounds.getScaleX(), bounds.getScaleY());
                object.setPosition(bounds.getX(), bounds.getY());
                object.draw(batch);
        }





}

package com.mygdx.game.Control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;
import com.mygdx.game.GameScreen.GameScreen;


public class TargetController  {

    private Polygon targetBounds;
    private boolean flag;
    private float lengthX;
    private float lengthY;
    private float changeY;
    float speed = 18f;
    float side = 60f;
    public static int fails = 0;


    public TargetController(Polygon targetBounds){
            this.targetBounds = targetBounds;


    }

        public void handle (){

            lengthX = targetBounds.getScaleX();
            lengthY = targetBounds.getScaleY();

                if (lengthX <= side && lengthY <= side && flag!= true) {
                    targetBounds.setScale(lengthX + speed * GameScreen.deltaCS, lengthY + speed * GameScreen.deltaCS);
                                if (lengthX + speed * GameScreen.deltaCS > side && lengthY + speed * GameScreen.deltaCS > side ){flag = true;}
                } else { if (flag == true && lengthX > 1f && lengthY > 1f) {
                    targetBounds.setScale(lengthX - speed* GameScreen.deltaCS, lengthY - speed * GameScreen.deltaCS);
                    if (lengthX - speed * GameScreen.deltaCS < 1f && lengthY - speed * GameScreen.deltaCS < 1f ){
                        flag = false;
                        fails++;
                        targetBounds.setPosition(GameScreen.generateRandomFloat(1, 830), GameScreen.generateRandomFloat(1, 830));
                         }

                    }
                }


        }

        public void changeCoordinate(){

                changeY = (Gdx.input.getY() - 900)*(-1);



                if (flag != true){
                    lengthX +=  speed * GameScreen.deltaCS;
                    lengthY +=  speed * GameScreen.deltaCS;
                }

                if (flag == true){
                    lengthX -=  speed * GameScreen.deltaCS;
                    lengthY -=  speed * GameScreen.deltaCS;
                }

                if (Gdx.input.isTouched() && Gdx.input.getX() >= targetBounds.getX() && Gdx.input.getX() <= targetBounds.getX() + lengthX && changeY >= targetBounds.getY() && changeY <= targetBounds.getY() + lengthY){
                   targetBounds.setPosition(GameScreen.generateRandomFloat(1, 830), GameScreen.generateRandomFloat(1, 830));
                   targetBounds.setScale(side, side);
                }
        }

}

package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.game.GameMenuScreen.GameMenuScreen;
import com.mygdx.game.GameScreen.GameScreen;




public class MyGdxGame extends Game {

	public GameMenuScreen menu;
	public GameScreen game;

	@Override
	public void create() {
		menu = new GameMenuScreen(this);
		game = new GameScreen(this);
		setScreen(menu);
	}

	@Override
	public void setScreen(Screen screen) {
		super.setScreen(screen);
	}

}

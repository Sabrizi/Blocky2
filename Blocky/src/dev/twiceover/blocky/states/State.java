package dev.twiceover.blocky.states;

import java.awt.Graphics;

import dev.twiceover.blocky.Game;

public abstract class State {	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}
}

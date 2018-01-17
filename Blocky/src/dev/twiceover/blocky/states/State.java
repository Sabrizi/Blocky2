package dev.twiceover.blocky.states;

import java.awt.Graphics;

import dev.twiceover.blocky.Handler;

public abstract class State {	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
}

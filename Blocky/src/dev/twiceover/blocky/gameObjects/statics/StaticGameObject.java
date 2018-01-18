package dev.twiceover.blocky.gameObjects.statics;

import java.awt.Color;

import dev.twiceover.blocky.Handler;
import dev.twiceover.blocky.gameObjects.GameObject;

public abstract class StaticGameObject extends GameObject{
	
	public StaticGameObject(Handler handler, float x, float y, int width, int height, Color color) {
		super(handler, x,y,width,height, color);
	}
	
	
}

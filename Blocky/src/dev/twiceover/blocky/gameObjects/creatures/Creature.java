package dev.twiceover.blocky.gameObjects.creatures;

import dev.twiceover.blocky.gameObjects.GameObject;

public abstract class Creature extends GameObject{

	public static final int DEFAULT_HEALTH = 1;
	public static final float DEFAULT_SPEED = 1f;
	public static final int DEFAULT_WIDTH = 64, DEFAULT_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	
	public Creature(float x, float y, int width, int height) {
		super(x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0; 
		yMove = 0;
	}
	
	public void move() {
		x += xMove;
		y += yMove;
	}
	
	
	

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
}
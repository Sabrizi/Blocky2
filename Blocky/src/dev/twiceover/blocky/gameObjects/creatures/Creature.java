package dev.twiceover.blocky.gameObjects.creatures;

import java.awt.Color;

import dev.twiceover.blocky.Handler;
import dev.twiceover.blocky.gameObjects.GameObject;
import dev.twiceover.blocky.gameObjects.blocks.Block;

public abstract class Creature extends GameObject {

	public static final int DEFAULT_HEALTH = 1;
	public static final float DEFAULT_SPEED = 1f;
	public static final int CREATURE_WIDTH = 16, CREATURE_HEIGHT = 16;

	protected int health;
	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height, Color color) {
		super(handler, x, y, width, height, color);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		this.color = color;
	}

	public void move() {
		movex();
		movey();
	}

	public void movex() {
		if (xMove > 0) { // moving right

			int tx = (int)(x + xMove + bounds.x + bounds.width) / Block.BLOCK_WIDTH;

			if (!collisionWithBlock(tx, (int)(y + bounds.y) / Block.BLOCK_HEIGHT)
					&& !collisionWithBlock(tx, (int)(y + bounds.y + bounds.height) / Block.BLOCK_HEIGHT)) {
				x += xMove;
			} else {
				x = tx * Block.BLOCK_WIDTH - bounds.x - bounds.width - 1;
			}

		} else if (xMove < 0) { // left
			int tx = (int)(x + xMove + bounds.x) / Block.BLOCK_WIDTH;

			if (!collisionWithBlock(tx, (int)(y + bounds.y) / Block.BLOCK_HEIGHT)
					&& !collisionWithBlock(tx, (int)(y + bounds.y + bounds.height) / Block.BLOCK_HEIGHT)) {
				x += xMove;
			} else {
				x = tx * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH - bounds.x;
			}

		}
	}

	public void movey() {
		if (yMove < 0) { // up
			int ty = (int)(y + yMove + bounds.y) / Block.BLOCK_HEIGHT;
			if (!collisionWithBlock((int)(x + bounds.x) / Block.BLOCK_WIDTH, ty)
					&& !collisionWithBlock((int)(x + bounds.x + bounds.width) / Block.BLOCK_WIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Block.BLOCK_HEIGHT + Block.BLOCK_HEIGHT - bounds.y;
			}

		} else if (yMove > 0) { // Down
			int ty = (int)(y + yMove + bounds.y + bounds.height) / Block.BLOCK_HEIGHT;
			if (!collisionWithBlock((int)(x + bounds.x) / Block.BLOCK_WIDTH, ty)
					&& !collisionWithBlock((int)(x + bounds.x + bounds.width) / Block.BLOCK_WIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Block.BLOCK_HEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}

	protected boolean collisionWithBlock(int x, int y) {
		return !handler.getWorld().getBlock(x, y).isPassable();
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

package dev.twiceover.blocky.gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dev.twiceover.blocky.Handler;

public abstract class GameObject {
	protected float x, y;
	protected int width, height;
	protected Handler handler;
	protected Rectangle bounds;
	protected Color color;

	public GameObject(Handler handler, float x, float y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.handler = handler;
		this.color = color;

		bounds = new Rectangle(0, 0, width, height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public Boolean checkObjectCollisions(float xoffset, float yoffset) {
		for (GameObject o : handler.getWorld().getObjectManager().getObjects()) {
			if (o.equals(this)) {
				continue;
			}
			if (o.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xoffset, yoffset))) {
				return true;
			}
		}
		return false;
	}

	public Rectangle getCollisionBounds(float xoffset, float yoffset) {
		return new Rectangle((int)(x + bounds.x + xoffset), (int)(y + bounds.y + yoffset), bounds.width, bounds.height);
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void tick();

	public abstract void render(Graphics g);
}

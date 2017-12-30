package dev.twiceover.blocky.gameObjects.blocks;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Block {

	public static final int BLOCK_WIDTH = 16, BLOCK_HEIGHT = 16;

	protected final int id;
	protected Color color;

	public Block(int id, Color color) {
		this.color = color;
		this.id = id;

		BlockManager.blocks[id] = this;
	}

	public void tick() {

	}

	public void render(Graphics g, int x, int y) {
		g.setColor(color);
		g.fillRect(x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
	}

	public boolean isPassable() {
		return false;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}

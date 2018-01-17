package dev.twiceover.blocky.gfx;

import dev.twiceover.blocky.Handler;
import dev.twiceover.blocky.gameObjects.GameObject;
import dev.twiceover.blocky.gameObjects.blocks.Block;

public class GameCamera {
	
	private float xoffset, yoffset;
	private Handler handler;
	
	

	public GameCamera(Handler handler, float xoffset, float yoffset) {
		this.xoffset = xoffset;
		this.yoffset = yoffset;
		this.handler = handler;
	}
	
	public void centerOnGameObject(GameObject go) {
		xoffset = go.getX() - handler.getWidth() / 2 + go.getWidth() / 2;
		yoffset = go.getY() - handler.getWidth() / 2 + go.getHeight() / 2;
		checkBlankSpace();
	}
	
	public void move(float xamt, float yamt) {
		this.xoffset += xamt;
		this.yoffset += yamt;
		checkBlankSpace();
	}
	
	public void checkBlankSpace() {
		if(xoffset < 0) {
			xoffset = 0;
		} else if(xoffset > handler.getWorld().getWidth() * Block.BLOCK_WIDTH - handler.getWidth()) {
			xoffset = handler.getWorld().getWidth() * Block.BLOCK_WIDTH - handler.getWidth();
		}
		
		if(yoffset < 0) {
			yoffset = 0;
		} else if(yoffset > handler.getWorld().getHeight() * Block.BLOCK_HEIGHT - handler.getHeight()) {
			yoffset = handler.getWorld().getHeight() * Block.BLOCK_HEIGHT - handler.getHeight();
		}
	}
	
	public float getXoffset() {
		return xoffset;
	}

	public void setXoffset(float xoffset) {
		this.xoffset = xoffset;
	}

	public float getYoffset() {
		return yoffset;
	}

	public void setYoffset(float yoffset) {
		this.yoffset = yoffset;
	}
}

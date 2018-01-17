package dev.twiceover.blocky.gameObjects.creatures;

import java.awt.Color;
import java.awt.Graphics;

import dev.twiceover.blocky.Handler;
import dev.twiceover.blocky.gameObjects.blocks.Block;

public class Player extends Creature {

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.CREATURE_WIDTH, Creature.CREATURE_HEIGHT, Color.RED);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = Block.BLOCK_WIDTH - 1;
		bounds.height = Block.BLOCK_HEIGHT - 1;
		
		setSpeed(5f);
	}

	@Override
	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnGameObject(this);
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().up) {
			yMove = -speed;
		}
		if (handler.getKeyManager().down) {
			yMove = speed;
		}
		if (handler.getKeyManager().left) {
			xMove = -speed;
		}
		if (handler.getKeyManager().right) {
			xMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int)(x - handler.getGameCamera().getXoffset()), (int)(y - handler.getGameCamera().getYoffset()), width, height);
//		g.setColor(Color.green);
//		g.fillRect((int)(x + bounds.x - handler.getGameCamera().getXoffset()), 
//				(int)(x + bounds.x - handler.getGameCamera().getXoffset()), 
//				bounds.width, bounds.height);
	}
}





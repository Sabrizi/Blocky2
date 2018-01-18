package dev.twiceover.blocky.gameObjects.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.twiceover.blocky.Handler;
import dev.twiceover.blocky.gameObjects.blocks.Block;
import dev.twiceover.blocky.gfx.Animation;
import dev.twiceover.blocky.gfx.Assets;

public class Player extends Creature {

	private Animation animDown;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.CREATURE_WIDTH, Creature.CREATURE_HEIGHT, Color.RED);

		bounds.x = 0;
		bounds.y = 0;
		bounds.width = Block.BLOCK_WIDTH - 1;
		bounds.height = Block.BLOCK_HEIGHT - 1;

		setSpeed(5f);

		// Animations
		animDown = new Animation(500, Assets.player_down);
	}

	@Override
	public void tick() {
		// Animations
		animDown.tick();
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
		// Animations
		// g.drawImage(getCurrentAnimationFrame(), (int)(x -
		// handler.getGameCamera().getXoffset()),
		// (int)(y - handler.getGameCamera().getYoffset()), width, height, null);

		// This is the player's red square
		g.setColor(color);
		g.fillRect((int)(x - handler.getGameCamera().getXoffset()), (int)(y - handler.getGameCamera().getYoffset()),
				width, height);

		// g.setColor(Color.green);
		// g.fillRect((int)(x + bounds.x - handler.getGameCamera().getXoffset()),
		// (int)(x + bounds.x - handler.getGameCamera().getXoffset()),
		// bounds.width, bounds.height);
	}

	private BufferedImage getCurrentAnimationFrame() {
		// if(xMove < 0) {
		// return animLeft.getCurrentFrame();
		// } else if(xMove > 0) {
		// return animRight.getCurrentFrame();
		// } else if(yMove < 0) {
		// return animUp.getCurrentFrame();
		// } else if(yMove > 0) {
		// return animDown.getCurrentFrame();
		// } else {
		// return animIdle.getCurrentFrame();
		// }

		return animDown.getCurrentFrame();
	}
}

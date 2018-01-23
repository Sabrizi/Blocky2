package dev.twiceover.blocky.gameObjects.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.twiceover.blocky.Handler;
import dev.twiceover.blocky.gameObjects.GameObject;
import dev.twiceover.blocky.gameObjects.blocks.Block;
import dev.twiceover.blocky.gfx.Animation;
import dev.twiceover.blocky.gfx.Assets;

public class Player extends Creature {

	private Animation animDown;
	
	private long lastAttackTimer, attackCooldown = 200, attackTimer = attackCooldown;

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

		// attacks
		checkAttacks();
	}

	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		
		if(attackTimer < attackCooldown) {
			return;
		}
		
		Rectangle cb = getCollisionBounds(0f, 0f);
		Rectangle ar = new Rectangle();

		int arSize = 16;

		ar.width = arSize;
		ar.height = arSize;

		if (handler.getKeyManager().aUp) {
			ar.x = cb.x + (cb.width / 2) - (arSize / 2);
			ar.y = cb.y - arSize;
		} else if (handler.getKeyManager().aDown) {
			ar.x = cb.x + (cb.width / 2) - (arSize / 2);
			ar.y = cb.y + cb.height;
		} else if (handler.getKeyManager().aLeft) {
			ar.x = cb.x - arSize;
			ar.y = cb.y + (cb.height / 2) - (arSize / 2);
		} else if (handler.getKeyManager().aRight) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + (cb.height / 2) - (arSize / 2);
		} else {
			return;
		}
		
		attackTimer = 0;
		
		for(GameObject o : handler.getWorld().getObjectManager().getObjects()) {
			if(o.equals(this)) {
				continue;
			}
			if(o.getCollisionBounds(0f, 0f).intersects(ar)) {
				o.hurt(1);
				return;
			}
		}
		
	}

	@Override
	public void die() {
		System.out.println("you lose");
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

		//Bounding box
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

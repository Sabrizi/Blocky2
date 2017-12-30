package dev.twiceover.blocky.gameObjects.creatures;

import java.awt.Color;
import java.awt.Graphics;

import dev.twiceover.blocky.Game;

public class Player extends Creature {

	private Game game;

	public Player(float x, float y, Game game) {
		super(x, y, Creature.CREATURE_WIDTH, Creature.CREATURE_HEIGHT, Color.RED);
		this.game = game;
		setSpeed(5f);
	}

	@Override
	public void tick() {
		getInput();
		move();
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (game.getKeyManager().up) {
			yMove = -speed;
		}
		if (game.getKeyManager().down) {
			yMove = speed;
		}
		if (game.getKeyManager().left) {
			xMove = -speed;
		}
		if (game.getKeyManager().right) {
			xMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y, width, height);
	}

}

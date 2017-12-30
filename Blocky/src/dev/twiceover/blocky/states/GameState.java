package dev.twiceover.blocky.states;

import java.awt.Graphics;

import dev.twiceover.blocky.Game;
import dev.twiceover.blocky.gameObjects.creatures.Player;

public class GameState extends State {

	private Player player;
	
	public GameState(Game game) {
		super(game);
		player = new Player(100, 100, game);
	}

	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}

}

package dev.twiceover.blocky.states;

import java.awt.Graphics;

import dev.twiceover.blocky.Game;
import dev.twiceover.blocky.gameObjects.creatures.Player;
import dev.twiceover.blocky.worlds.World;

public class GameState extends State {

	private Player player;
	private World world;
	
	public GameState(Game game) {
		super(game);
		player = new Player(100, 100, game);
		world = new World("assets/worlds/world2.txt");
	}

	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}

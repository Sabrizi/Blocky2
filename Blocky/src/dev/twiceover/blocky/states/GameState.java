package dev.twiceover.blocky.states;

import java.awt.Graphics;

import dev.twiceover.blocky.Handler;
import dev.twiceover.blocky.gameObjects.creatures.Player;
import dev.twiceover.blocky.worlds.World;

public class GameState extends State {

	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "assets/worlds/world2.txt");
		handler.setWorld(world);
	}

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}

package dev.twiceover.blocky.gameObjects;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import dev.twiceover.blocky.Handler;
import dev.twiceover.blocky.gameObjects.creatures.Player;

public class GameObjectManager {

	private Handler handler;
	private Player player;
	private ArrayList<GameObject> objects;

	public GameObjectManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		objects = new ArrayList<GameObject>();
		objects.add(player);
	}

	public void tick() {
		Iterator<GameObject> it = objects.iterator();
		while (it.hasNext()) {
			GameObject o = it.next();
			o.tick();
			if (!o.isActive()) {
				it.remove();
			}
		}
	}

	public void render(Graphics g) {
		for (GameObject o : objects) {
			o.render(g);
		}
	}

	public void addGameObject(GameObject g) {
		objects.add(g);
	}

	// Getters/setters
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<GameObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<GameObject> objects) {
		this.objects = objects;
	}
}

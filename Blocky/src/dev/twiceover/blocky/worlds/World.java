package dev.twiceover.blocky.worlds;

import java.awt.Graphics;

import dev.twiceover.blocky.Handler;
import dev.twiceover.blocky.gameObjects.GameObjectManager;
import dev.twiceover.blocky.gameObjects.blocks.Block;
import dev.twiceover.blocky.gameObjects.blocks.BlockManager;
import dev.twiceover.blocky.gameObjects.creatures.Player;
import dev.twiceover.blocky.gameObjects.statics.Tree;
import dev.twiceover.blocky.items.ItemManager;
import dev.twiceover.blocky.utils.Utils;

public class World {
	
	private Handler handler;
	private int width, height;
	private int spawnx, spawny;
	private int[][] blocks;
	
	private GameObjectManager objectManager;
	private ItemManager itemManager;

	public World(Handler handler, String path) {
		this.handler = handler;
		objectManager = new GameObjectManager(handler, new Player(handler, 100, 100));
		itemManager = new ItemManager(handler);
		objectManager.addGameObject(new Tree(handler, 200, 200));
		objectManager.addGameObject(new Tree(handler, 200, 216));
		objectManager.addGameObject(new Tree(handler, 200, 232));
		
		loadWorld(path);
		
		objectManager.getPlayer().setX(spawnx);
		objectManager.getPlayer().setY(spawny);
	}

	public void tick() {
		itemManager.tick();
		objectManager.tick();
	}

	public void render(Graphics g) {
		//This is for culling out the blocks that aren't visable.
		int xstart = (int)Math.max(0, handler.getGameCamera().getXoffset() / Block.BLOCK_WIDTH);
		int xend = (int)Math.min(width, (handler.getGameCamera().getXoffset() + handler.getWidth()) / Block.BLOCK_WIDTH + 1);
		int ystart = (int)Math.max(0, handler.getGameCamera().getYoffset() / Block.BLOCK_WIDTH);
		int yend = (int)Math.min(height, (handler.getGameCamera().getYoffset() + handler.getHeight()) / Block.BLOCK_HEIGHT + 1);

		for (int y = ystart; y < yend; y++) {
			for (int x = xstart; x < xend; x++) {
				getBlock(x, y).render(g, (int)(x * Block.BLOCK_WIDTH - handler.getGameCamera().getXoffset()),
						(int)(y * Block.BLOCK_HEIGHT - handler.getGameCamera().getYoffset()));
			}
		}
		
		itemManager.render(g);
		objectManager.render(g);
	}

	public Block getBlock(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) {
			return BlockManager.grassBlock;
		}
		
		Block b = BlockManager.blocks[blocks[x][y]];
		if (b == null) return BlockManager.airBlock;
		return b;
	}

	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnx = Utils.parseInt(tokens[2]);
		spawny = Utils.parseInt(tokens[3]);

		blocks = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				blocks[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public GameObjectManager getObjectManager() {
		return objectManager;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
}

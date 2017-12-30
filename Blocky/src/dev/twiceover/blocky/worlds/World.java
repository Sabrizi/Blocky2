package dev.twiceover.blocky.worlds;

import java.awt.Graphics;

import dev.twiceover.blocky.gameObjects.blocks.Block;
import dev.twiceover.blocky.gameObjects.blocks.BlockManager;
import dev.twiceover.blocky.utils.Utils;

public class World {
	private int width, height;
	private int spawnx, spawny;
	private int[][] blocks;

	public World(String path) {
		loadWorld(path);
	}

	public void tick() {

	}

	public void render(Graphics g) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				getBlock(x, y).render(g, x * Block.BLOCK_WIDTH, y * Block.BLOCK_HEIGHT);
			}
		}
	}

	public Block getBlock(int x, int y) {
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
}

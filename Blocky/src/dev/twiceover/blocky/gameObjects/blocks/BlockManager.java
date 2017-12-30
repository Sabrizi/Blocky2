package dev.twiceover.blocky.gameObjects.blocks;

public class BlockManager {
	public static Block[] blocks = new Block[256];
	
	public static Block airBlock = new AirBlock(0);
	public static Block dirtBlock = new DirtBlock(1);
	public static Block grassBlock = new GrassBlock(2);
	public static Block stoneBlock = new StoneBlock(3);
}

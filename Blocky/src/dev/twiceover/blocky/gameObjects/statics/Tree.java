package dev.twiceover.blocky.gameObjects.statics;

import java.awt.Color;
import java.awt.Graphics;

import dev.twiceover.blocky.Handler;
import dev.twiceover.blocky.gameObjects.blocks.Block;

public class Tree extends StaticGameObject {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Block.BLOCK_WIDTH, Block.BLOCK_HEIGHT, Color.GREEN);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.fillRect((int)(x - handler.getGameCamera().getXoffset()), (int)(y - handler.getGameCamera().getYoffset()),
				width, height);
	}

}

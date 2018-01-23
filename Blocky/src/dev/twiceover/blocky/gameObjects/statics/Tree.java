package dev.twiceover.blocky.gameObjects.statics;

import java.awt.Color;
import java.awt.Graphics;

import dev.twiceover.blocky.Handler;
import dev.twiceover.blocky.gameObjects.blocks.Block;
import dev.twiceover.blocky.items.Item;

public class Tree extends StaticGameObject {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Block.BLOCK_WIDTH, Block.BLOCK_HEIGHT, Color.GREEN);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = Block.BLOCK_WIDTH - 1;
		bounds.height = Block.BLOCK_HEIGHT - 1;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int)x, (int)y));
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.fillRect((int)(x - handler.getGameCamera().getXoffset()), (int)(y - handler.getGameCamera().getYoffset()),
				width, height);
	}

}

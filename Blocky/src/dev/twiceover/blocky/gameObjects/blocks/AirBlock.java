package dev.twiceover.blocky.gameObjects.blocks;
import dev.twiceover.blocky.gfx.BlockColors;

public class AirBlock extends Block{
	
	public AirBlock(int id) {
		super(id, BlockColors.air());
	}

	
	@Override
	public boolean isPassable() {
		return true;
	}
}

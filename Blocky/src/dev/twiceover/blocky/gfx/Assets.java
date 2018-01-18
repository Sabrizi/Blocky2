package dev.twiceover.blocky.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static final int width = 64, height = 64;
	
//	public static BufferedImage player, dirt, grass, stone;
	public static BufferedImage dirt, grass, stone;
	public static BufferedImage[] player_down;	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheet.png"));
		
		player_down = new BufferedImage[2];
		
		player_down[0] = sheet.crop(width, 0, width, height);
		player_down[1] = sheet.crop(0, height, width, height);
		
//		player = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(0, height, width, height);
		stone = sheet.crop(width, height, width, height);
		
	}
}

package dev.twiceover.blocky.states;

import java.awt.Graphics;

import dev.twiceover.blocky.Handler;
import dev.twiceover.blocky.gfx.Assets;
import dev.twiceover.blocky.ui.ClickListener;
import dev.twiceover.blocky.ui.UIImageButton;
import dev.twiceover.blocky.ui.UIManager;

public class MainMenuState extends State {

	private UIManager uiManager;

	public MainMenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(150, 150, 128, 128, Assets.player_down, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				StateManager.setState(handler.getGame().gameState);
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}

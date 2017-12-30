package dev.twiceover.blocky;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.twiceover.blocky.display.Display;
import dev.twiceover.blocky.gfx.Assets;
import dev.twiceover.blocky.input.KeyManager;
import dev.twiceover.blocky.states.GameState;
import dev.twiceover.blocky.states.MainMenuState;
import dev.twiceover.blocky.states.State;
import dev.twiceover.blocky.states.StateManager;

public class Game implements Runnable {

	// Private Variables
	private Display display;
	private Thread thread;
	private Boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	private KeyManager km;

	// Public Variables
	public int width, height;
	public String title;

	// States
	private State gameState;
	private State mainMenuState;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		km = new KeyManager();
	}

	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(km);
		Assets.init();

		gameState = new GameState(this);
		mainMenuState = new MainMenuState(this);
		StateManager.setState(gameState);
	}

	private void tick() {
		km.tick();
		
		State current = StateManager.getState();
		if (current != null) {
			current.tick();
		}
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();

		g.clearRect(0, 0, width, height);

		// Start Drawing
		State current = StateManager.getState();
		if (current != null) {
			current.render(g);
		}

		// End Drawing
		bs.show();
		g.dispose();
	}

	public void run() {
		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();

	}

	public KeyManager getKeyManager() {
		return this.km;
	}
	
	public synchronized void start() {
		if (running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

package core3d;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import GameCore.GameTime;

public abstract class Game
{
	GameTime gameTime;
	private boolean done = false;
	private boolean fullscreen = false;
	private DisplayMode displayMode;
	public String windowTitle = "No Title";

	public Game()
	{
		// TODO Auto-generated constructor stub
	}

	public void run(boolean fullscreen)
	{
		this.fullscreen = fullscreen;
		try
		{
			initInternal();
			while (!done)
			{
				updateInternal(gameTime);
				Display.update();
				Thread.sleep(20);
			}
			cleanup();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	

	private void initInternal() throws Exception
	{
		gameTime = new GameTime();
		createWindow();
		
		init();
	}

	private void updateInternal(GameTime gameTime2)
	{
		// TODO Auto-generated method stub
		update(gameTime);
	}

	protected abstract void update(GameTime gameTime2);

	protected abstract void init();

	private void createWindow() throws Exception
	{
		Display.setFullscreen(fullscreen);
		DisplayMode d[] = Display.getAvailableDisplayModes();
		for (int i = 0; i < d.length; i++)
		{
			if (d[i].getWidth() == 800 && d[i].getHeight() == 600
					&& d[i].getBitsPerPixel() == 32)
			{
				displayMode = d[i];
				break;
			}
		}
		Display.setDisplayMode(displayMode);
		Display.setTitle(windowTitle);
		Display.create();
	}
	private void cleanup()
	{
		Mouse.destroy();
        Keyboard.destroy();
		Display.destroy();
	}
}

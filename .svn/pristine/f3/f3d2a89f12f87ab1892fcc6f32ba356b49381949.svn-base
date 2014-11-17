package GameCore;
import static org.lwjgl.opengl.GL11.GL_AMBIENT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_DIFFUSE;
import static org.lwjgl.opengl.GL11.GL_LEQUAL;
import static org.lwjgl.opengl.GL11.GL_LIGHT1;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.GL_NICEST;
import static org.lwjgl.opengl.GL11.GL_PERSPECTIVE_CORRECTION_HINT;
import static org.lwjgl.opengl.GL11.GL_POSITION;
import static org.lwjgl.opengl.GL11.GL_SMOOTH;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glClearDepth;
import static org.lwjgl.opengl.GL11.glDepthFunc;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glHint;
import static org.lwjgl.opengl.GL11.glLight;
import static org.lwjgl.opengl.GL11.glShadeModel;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;


public abstract class Game3d implements Drawable, Updates, Initializes
{
	private boolean done = false;
	private boolean fullscreen = false;
	public String windowTitle = "No Title";
	private boolean f1 = false;
	private boolean f2 = false;
	private DisplayMode displayMode;
	public GameTime gameTime;
	final float[] AMBIENT = {.5f, .5f, .5f, 1f};

	//
	static
	{
		MODE.DEBUG(true);
	}
	
	public void run(boolean fullscreen)
	{
		this.fullscreen = fullscreen;
		try
		{
			init();
			while (!done)
			{
				reservedKeyQuery();
				clear();
				update(gameTime);
				draw();
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

	private void init() throws Exception
	{
		gameTime = new GameTime();
		createWindow();

		initGL();
		initialize();
	}

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
	
	private void initGL()
	{
		
		GL11.glEnable(GL11.GL_TEXTURE_2D); // Enable Texture Mapping
		GL11.glShadeModel(GL11.GL_SMOOTH); // Enable Smooth Shading
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // Black Background
		GL11.glClearDepth(1.0); // Depth Buffer Setup
		GL11.glEnable(GL11.GL_DEPTH_TEST); // Enables Depth Testing
		GL11.glDepthFunc(GL11.GL_LEQUAL); // The Type Of Depth Testing To Do

		GL11.glMatrixMode(GL11.GL_PROJECTION); // Select The Projection Matrix
		GL11.glLoadIdentity(); // Reset The Projection Matrix

		// Calculate The Aspect Ratio Of The Window
		GLU.gluPerspective(45.0f, (float) displayMode.getWidth()
				/ (float) displayMode.getHeight(), 0.1f, 100.0f);
		GL11.glMatrixMode(GL11.GL_MODELVIEW); // Select The Modelview Matrix

		// Really Nice Perspective Calculations
		GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
		
		ByteBuffer scratch = ByteBuffer.allocateDirect(16);
        scratch.order(ByteOrder.nativeOrder());
        glLight(GL_LIGHT1, GL_AMBIENT, (FloatBuffer)scratch.asFloatBuffer().put(AMBIENT).flip());  // 3rd argument used to be only scratch
        glLight(GL_LIGHT1, GL_DIFFUSE, (FloatBuffer)scratch.asFloatBuffer().put(AMBIENT).flip());
        glLight(GL_LIGHT1, GL_POSITION, (FloatBuffer)scratch.asFloatBuffer().put(AMBIENT).flip());
        GL11.glEnable(GL_LIGHT1);
        glEnable(GL_LIGHTING);
	}

	private void reservedKeyQuery()
	{
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
		{ // Exit if Escape is pressed
			done = true;
		}
		if (Display.isCloseRequested())
		{ // Exit if window is closed
			done = true;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_F1) && !f1)
		{ // Is F1 Being Pressed?
			f1 = true; // Tell Program F1 Is Being Held
			switchMode(); // Toggle Fullscreen / Windowed Mode
		}
		if (!Keyboard.isKeyDown(Keyboard.KEY_F1))
		{ // Is F1 Being Pressed?
			f1 = false;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_F2) && !f2)
		{ // Is F1 Being Pressed?
			f2 = true; // Tell Program F2 Is Being Held\
			if(!Mouse.isGrabbed())
			{
				Mouse.setGrabbed(true);
			}else
			{
				Mouse.setGrabbed(false);
			}
			
		}
		if (!Keyboard.isKeyDown(Keyboard.KEY_F2))
		{ // Is F2 Being Pressed?
			f2 = false;
		}
		
		if(MODE.DEBUG())
		{
			if (Mouse.isButtonDown(0))
			{
				int x = Mouse.getX();
				int y = Mouse.getY();

				System.out.println("Left Mouse Down @ X: " + x + " Y: " + y);
			}
			while (Keyboard.next())
			{
				if (Keyboard.getEventKeyState())
				{
					if (Keyboard.getEventKey() == Keyboard.KEY_A)
					{
						System.out.println("A Key Pressed");
					}
					if (Keyboard.getEventKey() == Keyboard.KEY_S)
					{
						System.out.println("S Key Pressed");
					}
					if (Keyboard.getEventKey() == Keyboard.KEY_D)
					{
						System.out.println("D Key Pressed");
					}
					if (Keyboard.getEventKey() == Keyboard.KEY_SPACE)
					{
						System.out.println("SPACE Key Pressed");
					}
					if (Keyboard.getEventKey() == Keyboard.KEY_LCONTROL)
					{
						System.out.println("LCTRL Key Pressed");
					}
				} else
				{
					if (Keyboard.getEventKey() == Keyboard.KEY_A)
					{
						System.out.println("A Key Released");
					}
					if (Keyboard.getEventKey() == Keyboard.KEY_S)
					{
						System.out.println("S Key Released");
					}
					if (Keyboard.getEventKey() == Keyboard.KEY_D)
					{
						System.out.println("D Key Released");
					}
					if (Keyboard.getEventKey() == Keyboard.KEY_SPACE)
					{
						System.out.println("SPACE Key Released");
					}
					if (Keyboard.getEventKey() == Keyboard.KEY_LCONTROL)
					{
						System.out.println("LCTRL Key Released");
					}
				}
			}
		}
	}

	private void switchMode()
	{
		fullscreen = !fullscreen;
		try
		{
			Display.setFullscreen(fullscreen);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void clear()
	{
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT
				| GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity(); // Reset The Current Modelview Matrix
	}

	private void cleanup()
	{
		Mouse.destroy();
        Keyboard.destroy();
		Display.destroy();
	}
}

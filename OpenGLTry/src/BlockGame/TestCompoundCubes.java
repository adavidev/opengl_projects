package BlockGame;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import GameCore.GameTime;

public class TestCompoundCubes extends GameObject
{
	private float rquad; // Angle For The Quad ( NEW )
	public float x, y, z;
	private float velx, vely, velz;
	int size = 3;

	CompoundCube[][][] ccube = new CompoundCube[size][size][size];

	public TestCompoundCubes()
	{
		z = -10;
		for (int a = 0; a < size; a++)
		{
			for (int b = 0; b < size; b++)
			{
				for (int c = 0; c < size; c++)
				{
					ccube[a][b][c] = CompoundCube.Instance();
				}
			}
		}
	}

	@Override
	public void initialize()
	{
		for (int a = 0; a < size; a++)
		{
			for (int b = 0; b < size; b++)
			{
				for (int c = 0; c < size; c++)
				{
					ccube[a][b][c].initialize();
				}
			}
		}
	}

	@Override
	public void draw()
	{
		GL11.glTranslatef(x, y, z); // Move Right 1.5 Units And Into The Screen
									// 6.0
		GL11.glRotatef(-rquad, 0.0f, 1.0f, 0.0f); // Rotate The Quad On The X
													// axis ( NEW )
		GL11.glColor3f(0.5f, 0.5f, 1.0f); // Set The Color To Blue One Time Only
		for (int a = 0; a < size; a++)
		{
			for (int b = 0; b < size; b++)
			{
				for (int c = 0; c < size; c++)
				{
					GL11.glTranslatef(a, b, c);
					ccube[a][b][c].draw();
					GL11.glTranslatef(-a, -b, -c);
				}
			}
		}
	}

	@Override
	public void update(GameTime gt)
	{
		velx = (float) Math.cos(Math.toRadians(rquad));
		velz = (float) Math.sin(Math.toRadians(rquad));
		// pollInput();
	}

//	public void pollInput()
//	{
//
//		if (Mouse.isButtonDown(0))
//		{
//			int x = Mouse.getX();
//			int y = Mouse.getY();
//
//			System.out.println("MOUSE DOWN @ X: " + x + " Y: " + y);
//		}
//
//		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE))
//		{
//			System.out.println("SPACE KEY IS DOWN");
//		}
//
//		if (Keyboard.isKeyDown(Keyboard.KEY_Q))
//		{
//			rquad -= 0.1f;
//		}
//
//		if (Keyboard.isKeyDown(Keyboard.KEY_E))
//		{
//			rquad += 0.1f;
//		}
//
//		if (Keyboard.isKeyDown(Keyboard.KEY_W))
//		{
//			z += 0.001f * velz;
//			x += 0.001f * velx;
//		}
//
//		if (Keyboard.isKeyDown(Keyboard.KEY_S))
//		{
//			z += 0.001f * -velz;
//			x += 0.001f * -velx;
//		}
//
//		if (Keyboard.isKeyDown(Keyboard.KEY_A))
//		{
//			x += 0.001f * (float) -Math.cos(Math.toRadians(rquad + 90));
//			z += 0.001f * (float) -Math.sin(Math.toRadians(rquad + 90));
//		}
//
//		if (Keyboard.isKeyDown(Keyboard.KEY_D))
//		{
//			x += 0.001f * (float) Math.cos(Math.toRadians(rquad + 90));
//			z += 0.001f * (float) Math.sin(Math.toRadians(rquad + 90));
//		}
//
//		while (Keyboard.next())
//		{
//			if (Keyboard.getEventKeyState())
//			{
//				if (Keyboard.getEventKey() == Keyboard.KEY_A)
//				{
//					System.out.println("A Key Pressed");
//				}
//				if (Keyboard.getEventKey() == Keyboard.KEY_S)
//				{
//					System.out.println("S Key Pressed");
//				}
//				if (Keyboard.getEventKey() == Keyboard.KEY_D)
//				{
//					System.out.println("D Key Pressed");
//				}
//			} else
//			{
//				if (Keyboard.getEventKey() == Keyboard.KEY_A)
//				{
//					System.out.println("A Key Released");
//				}
//				if (Keyboard.getEventKey() == Keyboard.KEY_S)
//				{
//					System.out.println("S Key Released");
//				}
//				if (Keyboard.getEventKey() == Keyboard.KEY_D)
//				{
//					System.out.println("D Key Released");
//				}
//			}
//		}
//	}
}
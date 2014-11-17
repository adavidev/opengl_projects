

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import BlockGame.GameObject;
import GameCore.GameTime;


public class TestQuad extends GameObject
{
    private float rquad;                // Angle For The Quad     ( NEW )
    private float posx, posy, posz;
    private float velx, vely, velz;

    @Override
    public void initialize()
    {
    	// TODO Auto-generated method stub
    	
    }
    
	@Override
	public void draw()
	{
		drawCube(posx,posy,posz);
	}

	@Override
	public void update(GameTime gt)
	{
		velx = (float) Math.cos(Math.toRadians(rquad));
		velz = (float) Math.sin(Math.toRadians(rquad));
		pollInput();
	}


	public void drawCube(float x, float y, float z)
    {

        GL11.glLoadIdentity();                          // Reset The Current Modelview Matrix
        GL11.glTranslatef(x,y,z);             // Move Right 1.5 Units And Into The Screen 6.0
        GL11.glRotatef(-rquad,0.0f,1.0f,0.0f);               // Rotate The Quad On The X axis ( NEW )
        GL11.glColor3f(0.5f,0.5f,1.0f);                 // Set The Color To Blue One Time Only
        GL11.glBegin(GL11.GL_QUADS);                        // Draw A Quad
            GL11.glColor3f(0.0f,1.0f,0.0f);             // Set The Color To Green
            GL11.glVertex3f( 1.0f, 1.0f,-1.0f);         // Top Right Of The Quad (Top)
            GL11.glVertex3f(-1.0f, 1.0f,-1.0f);         // Top Left Of The Quad (Top)
            GL11.glVertex3f(-1.0f, 1.0f, 1.0f);         // Bottom Left Of The Quad (Top)
            GL11.glVertex3f( 1.0f, 1.0f, 1.0f);         // Bottom Right Of The Quad (Top)
            GL11.glColor3f(1.0f,0.5f,0.0f);             // Set The Color To Orange
            GL11.glVertex3f( 1.0f,-1.0f, 1.0f);         // Top Right Of The Quad (Bottom)
            GL11.glVertex3f(-1.0f,-1.0f, 1.0f);         // Top Left Of The Quad (Bottom)
            GL11.glVertex3f(-1.0f,-1.0f,-1.0f);         // Bottom Left Of The Quad (Bottom)
            GL11.glVertex3f( 1.0f,-1.0f,-1.0f);         // Bottom Right Of The Quad (Bottom)
            GL11.glColor3f(1.0f,0.0f,0.0f);             // Set The Color To Red
            GL11.glVertex3f( 1.0f, 1.0f, 1.0f);         // Top Right Of The Quad (Front)
            GL11.glVertex3f(-1.0f, 1.0f, 1.0f);         // Top Left Of The Quad (Front)
            GL11.glVertex3f(-1.0f,-1.0f, 1.0f);         // Bottom Left Of The Quad (Front)
            GL11.glVertex3f( 1.0f,-1.0f, 1.0f);         // Bottom Right Of The Quad (Front)
            GL11.glColor3f(1.0f,1.0f,0.0f);             // Set The Color To Yellow
            GL11.glVertex3f( 1.0f,-1.0f,-1.0f);         // Bottom Left Of The Quad (Back)
            GL11.glVertex3f(-1.0f,-1.0f,-1.0f);         // Bottom Right Of The Quad (Back)
            GL11.glVertex3f(-1.0f, 1.0f,-1.0f);         // Top Right Of The Quad (Back)
            GL11.glVertex3f( 1.0f, 1.0f,-1.0f);         // Top Left Of The Quad (Back)
            GL11.glColor3f(0.0f,0.0f,1.0f);             // Set The Color To Blue
            GL11.glVertex3f(-1.0f, 1.0f, 1.0f);         // Top Right Of The Quad (Left)
            GL11.glVertex3f(-1.0f, 1.0f,-1.0f);         // Top Left Of The Quad (Left)
            GL11.glVertex3f(-1.0f,-1.0f,-1.0f);         // Bottom Left Of The Quad (Left)
            GL11.glVertex3f(-1.0f,-1.0f, 1.0f);         // Bottom Right Of The Quad (Left)
            GL11.glColor3f(1.0f,0.0f,1.0f);             // Set The Color To Violet
            GL11.glVertex3f( 1.0f, 1.0f,-1.0f);         // Top Right Of The Quad (Right)
            GL11.glVertex3f( 1.0f, 1.0f, 1.0f);         // Top Left Of The Quad (Right)
            GL11.glVertex3f( 1.0f,-1.0f, 1.0f);         // Bottom Left Of The Quad (Right)
            GL11.glVertex3f( 1.0f,-1.0f,-1.0f);         // Bottom Right Of The Quad (Right)
        GL11.glEnd();                                       // Done Drawing The Quad
    }
    
	public void drawQuad(int distance)
	{

        GL11.glLoadIdentity();                          // Reset The Current Modelview Matrix
        GL11.glTranslatef(1.5f,0.0f,-6.0f);             // Move Right 1.5 Units And Into The Screen 6.0
        GL11.glRotatef(rquad,1.0f,0.0f,0.0f);               // Rotate The Quad On The X axis ( NEW )
        GL11.glColor3f(0.5f,0.5f,1.0f);                 // Set The Color To Blue One Time Only
        GL11.glBegin(GL11.GL_QUADS);                        // Draw A Quad
            GL11.glVertex3f(-1.0f, 1.0f, 0.0f);         // Top Left
            GL11.glVertex3f( 1.0f, 1.0f, 0.0f);         // Top Right
            GL11.glVertex3f( 1.0f,-1.0f, 0.0f);         // Bottom Right
            GL11.glVertex3f(-1.0f,-1.0f, 0.0f);         // Bottom Left
        GL11.glEnd();                                       // Done Drawing The Quad

        GL11.glLoadIdentity();
	}
	
	public void pollInput()
	{

		if (Mouse.isButtonDown(0))
		{
			int x = Mouse.getX();
			int y = Mouse.getY();

			System.out.println("MOUSE DOWN @ X: " + x + " Y: " + y);
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		{
			System.out.println("SPACE KEY IS DOWN");
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_Q))
		{
			rquad-=0.1f;
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_E))
		{
			rquad+=0.1f;
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_W))
		{
			posz+=0.001f * velz;
			posx+=0.001f * velx;
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_S))
		{
			posz+=0.001f * -velz;
			posx+=0.001f * -velx;
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_A))
		{
			posx+=0.001f * (float) -Math.cos(Math.toRadians(rquad + 90));
			posz+=0.001f * (float) -Math.sin(Math.toRadians(rquad + 90));
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
		{
			posx+=0.001f * (float) Math.cos(Math.toRadians(rquad + 90));
			posz+=0.001f * (float) Math.sin(Math.toRadians(rquad + 90));
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
			}
		}
	}
}

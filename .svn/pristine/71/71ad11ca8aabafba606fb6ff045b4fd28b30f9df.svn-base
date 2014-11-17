package GameCore;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;


public class Camera
{
	static float x = 0;
	static float y = 0;
	static float z = 0;
	static float rotx = 0;
	static float roty = 0;
	static float rotz = 0;
	private static final float piover180 = 0.0174532925f;
	public static float mouseSensitivity = 0.5f;
	public static float cameraSpeed = 0.05f;
	
	public static void setCamera()
	{
		GL11.glRotatef(rotz,1.0f,0,0);
        GL11.glRotatef(roty,0,1.0f,0);

        GL11.glTranslatef(-x, -y, -z);
	}
	
	public static void useCameraControls()
	{

		if (Mouse.isButtonDown(0))
		{
			roty += Mouse.getDX() * mouseSensitivity;
			rotz -= Mouse.getDY() * mouseSensitivity;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		{
			y += .1f;
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL))
		{
			y -= .1f;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_Q))
		{
			rotz-=0.1f;
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_E))
		{
			rotz+=0.1f;
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_W))
		{
	            x -= (float) (Math.sin(-roty * piover180) * Math.cos(rotz * piover180)) * cameraSpeed;
	            z -= (float) (Math.cos(-roty * piover180) * Math.cos(rotz * piover180)) * cameraSpeed;
	            y += (float) Math.sin(-rotz * piover180) * cameraSpeed;
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_S))
		{
	            x += (float) (Math.sin(-roty * piover180) * Math.cos(rotz * piover180)) * cameraSpeed;
	            z += (float) (Math.cos(-roty * piover180) * Math.cos(rotz * piover180)) * cameraSpeed;
	            y -= (float) Math.sin(-rotz * piover180) * cameraSpeed;
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_A))
		{
			x -= (float) (Math.cos(-roty * piover180) * cameraSpeed);
            z += (float) (Math.sin(-roty * piover180) * cameraSpeed);
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
		{
			x += (float) (Math.cos(-roty * piover180) * cameraSpeed);
            z -= (float) (Math.sin(-roty * piover180) * cameraSpeed);
		}
	}
}

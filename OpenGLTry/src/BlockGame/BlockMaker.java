package BlockGame;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import GameCore.Camera;
import GameCore.Game3d;
import GameCore.GameTime;


public class BlockMaker extends Game3d
{
//	TestQuad tq;
	TestCompoundCubes tq;
	
	
	public BlockMaker()
	{
		super();
		tq = new TestCompoundCubes();
	}

	@Override
	public void initialize()
	{
		tq.initialize();

	}
	
	@Override
	public void update(GameTime gt)
	{
		Camera.useCameraControls();
		Camera.setCamera();
		tq.update(gt);
	}

	@Override
	public void draw()
	{
		tq.draw();
	}
	
	public static void main(String args[])
	{
		boolean fullscreen = false;
		if (args.length > 0)
		{
			if (args[0].equalsIgnoreCase("fullscreen"))
			{
				fullscreen = true;
			}
		}

		BlockMaker bm = new BlockMaker();
		bm.run(fullscreen);
	}
	
}

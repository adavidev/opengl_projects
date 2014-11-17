package core3d.utility;

import static org.lwjgl.opengl.GL11.GL_AMBIENT;
import static org.lwjgl.opengl.GL11.GL_DIFFUSE;
import static org.lwjgl.opengl.GL11.GL_LIGHT1;
import static org.lwjgl.opengl.GL11.GL_POSITION;
import static org.lwjgl.opengl.GL11.glLight;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import org.lwjgl.opengl.GL11;

import core3d.Entity;
import core3d.Node;
import core3d.RenderObject;

public class LightRender extends RenderObject {

	private float lightAmbient[] = { 0.5f, 0.5f, 0.5f, 1.0f };  // Ambient Light Values ( NEW )
    private float lightDiffuse[] = { 1.0f, 1.0f, 1.0f, 1.0f };      // Diffuse Light Values ( NEW )
    private float lightPosition[] = { 0.0f, 0.0f, 2.0f, 1.0f }; // Light Position ( NEW )
    final static float[] AMBIENT = { .5f, .5f, .5f, 1f };
	
	public LightRender(Node node) {
		super(node);
		ByteBuffer scratch = ByteBuffer.allocateDirect(16);
        scratch.order(ByteOrder.nativeOrder());
        glLight(GL_LIGHT1, GL_AMBIENT, (FloatBuffer)scratch.asFloatBuffer().put(AMBIENT).flip());  // 3rd argument used to be only scratch
        glLight(GL_LIGHT1, GL_DIFFUSE, (FloatBuffer)scratch.asFloatBuffer().put(AMBIENT).flip());
        glLight(GL_LIGHT1, GL_POSITION, (FloatBuffer)scratch.asFloatBuffer().put(AMBIENT).flip());
        GL11.glEnable(GL_LIGHT1);
	}

	public void init() {
		super.init();
	}
	
	@Override
	public void render() {
	}

}

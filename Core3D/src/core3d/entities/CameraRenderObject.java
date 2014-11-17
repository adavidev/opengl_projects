package core3d.entities;

import org.lwjgl.opengl.GL11;

import core3d.Node;
import core3d.RenderObject;

public class CameraRenderObject extends RenderObject {

	public CameraRenderObject(Node node) {
		super(node);
		// TODO Auto-generated constructor stub
	}
	
	// set to override default list adding
	public void init() {
		
	}

	@Override
	public void render() {
		setCamera();
	}

	public void setCamera()
	{
		GL11.glRotatef(node.rotzg,1.0f,0,0);
        GL11.glRotatef(node.rotyg,0,1.0f,0);

        GL11.glTranslatef(-node.xg, -node.yg, -node.zg);
	}
}

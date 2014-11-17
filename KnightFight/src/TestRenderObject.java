

import org.lwjgl.opengl.GL11;

import core3d.Entity;
import core3d.Node;
import core3d.RenderObject;
import core3d.basic3D.Triangle;
import core3d.objImport.ObjImport;

public class TestRenderObject extends RenderObject {

	Triangle[] tlist;
	
	public TestRenderObject(Node entity) {
		super(entity);
		tlist = ObjImport.modelImport3("tryCube.obj");
	}

	@Override
	public void render() {
		//translates to global point from origin, but moves back to local at end. If a node is used, they will reset to parent origin
        GL11.glTranslatef(node.xg,0.0f,node.zg);             // Move Right 1.5 Units And Into The Screen 6.0
        GL11.glRotatef(0,1.0f,0.0f,0.0f);               // Rotate The Quad On The X axis ( NEW )
        GL11.glColor3f(0.5f,0.5f,1.0f);                 // Set The Color To Blue One Time Only
		for (Triangle t : tlist)
		{
				t.render();
		}                                       // Done Drawing The tri
		GL11.glTranslatef(-node.xl,0.0f,-node.zl);
	}

}

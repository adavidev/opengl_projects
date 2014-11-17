package Basic3D;

import static org.lwjgl.opengl.GL11.glNormal3f;

import java.awt.geom.Point2D;

import org.lwjgl.opengl.GL11;

import GameCore.Drawable;

/**
 * A drawable OpenGL Quad using Vertices
 * 
 * @author Alan
 * 
 */
public class Quad implements Drawable
{
	public Vertex[] vertices;
	public fPoint2D[] texCoords;
	public Vector3f normal;

	public Quad(Vertex v1, Vertex v2, Vertex v3, Vertex v4, fPoint2D t1,
			fPoint2D t2, fPoint2D t3, fPoint2D t4, Vector3f normal)
	{
		vertices = new Vertex[4];
		vertices[0] = v1;
		vertices[1] = v2;
		vertices[2] = v3;
		vertices[3] = v4;

		texCoords = new fPoint2D[4];
		texCoords[0] = t1;
		texCoords[1] = t2;
		texCoords[2] = t3;
		texCoords[3] = t4;
		
		this.normal = normal;
	}
	
	public Quad(Vertex v1, Vertex v2, Vertex v3, Vertex v4)
	{
		this(v1, v2,v3,v4,new fPoint2D(0,0),new fPoint2D(1,0),new fPoint2D(1,1),new fPoint2D(0,1), new Vector3f(1, 1, 1));
	}

	@Override
	public void draw()
	{
		GL11.glBegin(GL11.GL_QUADS);                        // Draw Quads
		glNormal3f(normal.x, normal.y, normal.z);
		for (int i = 0; i < vertices.length; i++)
		{
			GL11.glTexCoord2f(texCoords[i].x,texCoords[i].y);
			vertices[i].draw();
		}
		GL11.glEnd();   
	}

}

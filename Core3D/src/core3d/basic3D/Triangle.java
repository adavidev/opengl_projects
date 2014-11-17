package core3d.basic3D;

import static org.lwjgl.opengl.GL11.glNormal3f;

import org.lwjgl.opengl.GL11;

public class Triangle
{
	public Vertex[] vertices;
	public fPoint2D[] texCoords;
	public Vector3f normal;
	
	public Triangle(Vertex v1,Vertex v2,Vertex v3)
	{
		this(v1,v2,v3,new fPoint2D(0, 0),new fPoint2D(1, 0),new fPoint2D(.5f, 1),new Vector3f(0,0,0));
	}
	
	public Triangle(Vertex v1,Vertex v2,Vertex v3, fPoint2D t1, fPoint2D t2, fPoint2D t3, Vector3f normal)
	{
		vertices = new Vertex[3];
		vertices[0] = v1;
		vertices[1] = v2;
		vertices[2] = v3;

		texCoords = new fPoint2D[3];
		texCoords[0] = t1;
		texCoords[1] = t2;
		texCoords[2] = t3;
		
		this.normal = normal;
	}
	
	public void render()
	{
		GL11.glBegin(GL11.GL_TRIANGLES);                        // Draw Triangles
		glNormal3f(normal.x, normal.y, normal.z);
		for (int i = 0; i < vertices.length; i++)
		{
			GL11.glTexCoord2f(texCoords[i].x,texCoords[i].y);
			vertices[i].render();
		}
		GL11.glEnd(); 
	}
	
	public Vector3f get(int i)
	{
		return vertices[i].toVector();
	}

	

}

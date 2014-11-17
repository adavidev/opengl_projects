package core3d.basic3D;

import javax.sound.sampled.ReverbType;

import org.lwjgl.opengl.GL11;

/**
 * A 3d point used to draw openGl objects
 * @author Alan
 */
public class Vertex
{
	public float[] numbers = new float[3];

	public Vertex(float x, float y, float z)
	{
		numbers[0] = x;
		numbers[1] = y;
		numbers[2] = z;
	}
	
	public Vertex(Vector3f point)
	{
		numbers[0] = point.x;
		numbers[1] = point.y;
		numbers[2] = point.z;
	}

	public void render()
	{
		GL11.glVertex3f(numbers[0],	numbers[1],	numbers[2] );
	}
	
	public Vector3f toVector()
	{
		return new Vector3f(numbers[0],numbers[1],numbers[2]);
	}
	
	/**
	 * parses a list of float values into a list of 3d vertices
	 * @param floatlist
	 * a list of float values to be parsed
	 * @return a list of vertices
	 */
	public static Vertex[] parseVertexList(float...floatlist)
	{
		Vertex[] retValue = null;
		
		if (floatlist.length % 3 == 0)
		{
			retValue = new Vertex[floatlist.length / 3];
			
			for (int i = 0; i < floatlist.length; i++)
			{
				retValue[i / 3] = new Vertex(0,0,0);
				retValue[i / 3].numbers[i % 3] = floatlist[i];
			}
		}
		
		return retValue;
	}
	
	/**
	 * parses a list of point values into a list of 3d vertices
	 * @param floatlist
	 * a list of float values to be parsed
	 * @return a list of vertices
	 */
	public static Vertex[] parseVertexList(Vector3f... pointlist)
	{
		Vertex[] retValue = null;

		retValue = new Vertex[pointlist.length];
		for(int i = 0; i < pointlist.length; i++)
		{
			retValue[i] = new Vertex(pointlist[i]);
		}

		return retValue;
	}
}

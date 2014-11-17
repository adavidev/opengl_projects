package core3d;

import java.util.ArrayList;

public class RenderManager
{
	public static ArrayList<RenderObject> renderList = new ArrayList<RenderObject>();
	
	public static void add(RenderObject renderObject)
	{
		renderList.add(renderObject);
	}
	
	public static void render() 
	{
		for (RenderObject renderObject : renderList)
		{
			renderObject.doRender();
		}
	}
}

package core3d;

public abstract class RenderObject
{
	protected Node node;

	public RenderObject(Node entity)
	{
		this.node = entity;
	}

	public void init()
	{
		RenderManager.add(this);
	}
	
	public void doRender()
	{
		// TODO Auto-generated method stub
		render();
	}
	
	public abstract void render();

}

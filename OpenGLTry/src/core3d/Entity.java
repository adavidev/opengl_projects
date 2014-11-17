package core3d;

public abstract class Entity
{
	public RenderObject renderObject;

	public Entity()
	{
		// TODO Auto-generated constructor stub
	}
	
	public abstract void init();
	
	public abstract void update();

}

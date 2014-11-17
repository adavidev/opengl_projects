package core3d;

public abstract class Entity
{
	public RenderObject renderObject;
	public float xg = 0;
	public float yg = 0;
	public float zg = 0;
	public float xl = 0;
	public float yl = 0;
	public float zl = 0;
	public float rotxg = 0;
	public float rotyg = 0;
	public float rotzg = 0;
	public float rotxl = 0;
	public float rotyl = 0;
	public float rotzl = 0;

	public Entity()
	{
		super();
	}
	
	public abstract void init();
	
	public abstract void update();

}

package core3d;


public class GameTime {
	public long currentTime = System.currentTimeMillis();
	public long elapsedTime;
	public long startTime;
	
	public GameTime()
	{
		startTime = System.currentTimeMillis();
		elapsedTime = 0;
	}
	
	public void update()
	{
		elapsedTime = System.currentTimeMillis() - currentTime;
		currentTime = System.currentTimeMillis();
	}
}

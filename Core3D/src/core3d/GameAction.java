package core3d;

public abstract class GameAction {

	protected Object o;
	
	public GameAction(Object o) {
		this.o = o;
	}
	
	public abstract void doAction();
}

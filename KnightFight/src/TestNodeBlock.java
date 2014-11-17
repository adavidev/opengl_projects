

import org.lwjgl.input.Keyboard;

import core3d.GameAction;
import core3d.Input;
import core3d.Node;

public class TestNodeBlock extends Node {
	
	public TestNodeBlock() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		super.init();
		renderObject = new TestRenderObject(this);
		renderObject.init();
		
		
		Input.bindKeyToName(Keyboard.KEY_E, "test1");
		Input.addAction("test1", new GameAction(this) {
			
			@Override
			public void doAction() {
				((TestNodeBlock)o).xl += 0.1f;
				System.out.println("test1 pressed.");
			}
		});
	}

	@Override
	public void update() {
		super.update();
		// TODO Auto-generated method stub

	}

}

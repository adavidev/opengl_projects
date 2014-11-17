package core3d.test;

import org.lwjgl.input.Keyboard;

import core3d.GameAction;
import core3d.Input;
import core3d.Node;

public class TestBlock extends Node {
	
	public TestBlock() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		super.init();
		renderObject = new TestRenderObject(this);
		renderObject.init();
		
		
		Input.bindKeyToName(Keyboard.KEY_Q, "test");
		Input.addAction("test", new GameAction(this) {
			
			@Override
			public void doAction() {
				((TestBlock)o).xl += 0.1f;
				System.out.println("test pressed.");
			}
		});
	}

	@Override
	public void update() {
		super.update();
		// TODO Auto-generated method stub

	}

}

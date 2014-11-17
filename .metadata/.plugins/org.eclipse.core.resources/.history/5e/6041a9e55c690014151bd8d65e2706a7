package core3d.test;

import core3d.Game;
import core3d.GameTime;
import core3d.entities.Camera;
import core3d.utility.Light;

public class TestGame extends Game {

	TestBlock tb = new TestBlock();
	TestNodeBlock tb1 = new TestNodeBlock();
	Light light = new Light();
	TestCamera cam = new TestCamera();
	
	public TestGame() {
		this.windowTitle = "Der GameStone";
	}

	@Override
	protected void update(GameTime gameTime2) {
		tb.update();
		tb1.update();
		cam.update();
	}

	@Override
	protected void init() {
		tb.init();
		tb1.init();
		tb1.zl = -6f;
		tb.addChild(tb1);
		light.init();
		cam.init();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestGame tg = new TestGame();
		tg.run(false);
	}

}

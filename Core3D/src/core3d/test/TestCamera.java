package core3d.test;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import core3d.GameAction;
import core3d.Input;
import core3d.entities.Camera;

public class TestCamera extends Camera {

	private static final float piover180 = 0.0174532925f;
	public float mouseSensitivity = 0.5f;
	public float cameraSpeed = 0.05f;
	
	public TestCamera() {
	}
	
	public void init() {
		super.init();
		
		Input.bindKeyToName(Keyboard.KEY_A, "left");
		Input.bindKeyToName(Keyboard.KEY_D, "right");
		Input.bindKeyToName(Keyboard.KEY_W, "forward");
		Input.bindKeyToName(Keyboard.KEY_S, "back");
		Input.bindKeyToName(Keyboard.KEY_SPACE, "up");
		
		Input.addAction("up", new GameAction(this) {
			@Override
			public void doAction() {
				TestCamera cam = ((TestCamera)o);
				cam.yg += .1f;
				System.out.println("space pressed.");
			}
		});
		
		Input.addAction("left", new GameAction(this) {
			@Override
			public void doAction() {
				TestCamera cam = ((TestCamera)o);
				cam.xg -= (float) (Math.cos(-cam.rotyg * cam.piover180) * cam.cameraSpeed);
				cam.zg += (float) (Math.sin(-cam.rotyg * cam.piover180) * cam.cameraSpeed);
				System.out.println("left pressed.");
			}
		});
		
		Input.addAction("right", new GameAction(this) {
			@Override
			public void doAction() {
				TestCamera cam = ((TestCamera)o);
				cam.xg += (float) (Math.cos(-cam.rotyg * cam.piover180) * cam.cameraSpeed);
				cam.zg -= (float) (Math.sin(-cam.rotyg * cam.piover180) * cam.cameraSpeed);
				System.out.println("left pressed.");
			}
		});
		
		Input.addAction("forward", new GameAction(this) {
			@Override
			public void doAction() {
				TestCamera cam = ((TestCamera)o);
				cam.xg -= (float) (Math.sin(-cam.rotyg * cam.piover180) * Math.cos(cam.rotzg * cam.piover180)) * cam.cameraSpeed;
	            cam.zg -= (float) (Math.cos(-cam.rotyg * cam.piover180) * Math.cos(cam.rotzg * cam.piover180)) * cam.cameraSpeed;
	            cam.yg += (float) Math.sin(-cam.rotzg * cam.piover180) * cam.cameraSpeed;
				System.out.println("forward pressed.");
			}
		});
		
		Input.addAction("back", new GameAction(this) {
			@Override
			public void doAction() {
				TestCamera cam = ((TestCamera)o);
				cam.xg += (float) (Math.sin(-cam.rotyg * cam.piover180) * Math.cos(cam.rotzg * cam.piover180)) * cam.cameraSpeed;
	            cam.zg += (float) (Math.cos(-cam.rotyg * cam.piover180) * Math.cos(cam.rotzg * cam.piover180)) * cam.cameraSpeed;
	            cam.yg -= (float) Math.sin(-cam.rotzg * cam.piover180) * cam.cameraSpeed;
				System.out.println("back pressed.");
			}
		});
	}
	
	public void update() {
		super.update();
		if (Mouse.isButtonDown(0))
		{
			rotyg += Mouse.getDX() * mouseSensitivity;
			rotzg -= Mouse.getDY() * mouseSensitivity;
			System.out.println("mouse pressed.");
		}
	}

}

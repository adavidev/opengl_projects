package core3d;

import java.util.HashMap;

import org.lwjgl.input.Keyboard;

public class Input {

	public static HashMap<Integer,String> inputs = new HashMap<Integer, String>();
	public static HashMap<String,GameAction> actions = new HashMap<String, GameAction>();
	
	
	public static void addAction(String name, GameAction action)
	{
		actions.put(name, action);
	}

	public static void bindKeyToName(int key, String name)
	{
		inputs.put(key, name);
	}

	public static void queryKeyPresses() {
		try
		{
			for (Integer keyPressed : inputs.keySet()) {
				if (Keyboard.isKeyDown(keyPressed))
				{
					actions.get(inputs.get(keyPressed)).doAction();
				}
			}
		}catch( Exception e)
		{
			System.err.println("keyPress failure: " + e);
		}
	}
}

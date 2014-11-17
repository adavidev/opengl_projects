package core3d;

import java.util.ArrayList;

import core3d.entities.Camera;

public class ViewContext {
	public static ArrayList<Camera> cameras = new ArrayList<Camera>();
	
	public static Camera currentView = null;
	
	public static void add(Camera camera) {
		cameras.add(camera);
	}
	
	public static void init() {
		if (currentView == null && cameras.size() > 0)
		{
			currentView = cameras.get(0);
		}
	}
}

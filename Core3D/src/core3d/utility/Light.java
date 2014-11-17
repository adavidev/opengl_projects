package core3d.utility;

import core3d.Entity;
import core3d.Node;

public class Light extends Node {

	public Light() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		renderObject = new LightRender(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}

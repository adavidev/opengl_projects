package core3d;

import java.util.ArrayList;

public class Node extends Entity {
	
	public ArrayList<Node> children;
	Node parent;
	
	public Node()
	{
		super();
		children = new ArrayList<Node>();
		parent = null;
	}
	
	public void addChild(Node e) {
		children.add(e);
		e.parent = this;
	}
	
	@Override
	public void update() {
		xg = 0f;
		yg = 0f;
		zg = 0f;
		
		
		if (parent != null) {
			xg = parent.xg;
			yg = parent.yg;
			zg = parent.zg;
		}
		xg = xg + xl;
		yg = yg + yl;
		zg = zg + zl;
	}

	@Override
	public void init() {
		
	}
}

package core3d.rendering;

import org.lwjgl.opengl.DisplayMode;

public interface IRenderer {
	public void init(DisplayMode displayMode);

	public void render();
}

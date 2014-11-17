package core3d;

import static org.lwjgl.opengl.GL11.GL_AMBIENT;
import static org.lwjgl.opengl.GL11.GL_DIFFUSE;
import static org.lwjgl.opengl.GL11.GL_LIGHT1;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.GL_POSITION;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import core3d.rendering.DefaultRenderer;
import core3d.rendering.IRenderer;

public class RenderManager {
	public static ArrayList<RenderObject> renderList = new ArrayList<RenderObject>();
	final static float[] AMBIENT = { .5f, .5f, .5f, 1f };
	static IRenderer loadedRenderer = null;

	public static void add(RenderObject renderObject) {
		renderList.add(renderObject);
	}

	public static void init(DisplayMode displayMode) {
		loadRenderer();
		
		if (loadedRenderer == null) {
			loadedRenderer = new DefaultRenderer();
		}
		
		loadedRenderer.init(displayMode);
	}

	private static void loadRenderer() {
		StringBuilder renderClass = new StringBuilder();
		Class<?> clazz;
		
		try
		{

			String line;
			BufferedReader dis = new BufferedReader(
					new FileReader("render.txt"));
			while ((line = dis.readLine()) != null)
			{
				renderClass.append(line);
			}
		
			clazz = Class.forName(renderClass.toString());
		
		Constructor<?> constructor = clazz.getConstructor();
		loadedRenderer = (IRenderer) constructor.newInstance();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No render file to read");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void render() {
		loadedRenderer.render();
	}
}

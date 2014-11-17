package core3d.objImport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import core3d.basic3D.Triangle;
import core3d.basic3D.Vertex;

public class ObjImport
{
//	public static Quad[] modelImport2(String FileToImport)
//	{
//		ArrayList<Vertex> vertList = new ArrayList<Vertex>();
//		ArrayList<Quad> quadList = new ArrayList<Quad>();
//		StringBuilder wholeText = new StringBuilder();
//
//		try
//		{
//
//			String line;
//			BufferedReader dis = new BufferedReader(
//					new FileReader(FileToImport));
//			while ((line = dis.readLine()) != null)
//			{
//				wholeText.append(line);
//			}
//		}
//		catch (FileNotFoundException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		catch (IOException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		int i2 = 0;
//		for (int i = 0; i < wholeText.length(); i++)
//		{
//			// get a vertex
//			if (wholeText.charAt(i) == 'v' && wholeText.charAt(i + 1) == ' ')
//			{
//				i2 = i + 2;
//				for (int a = i2; a < wholeText.length(); a++)
//				{
//					if (wholeText.charAt(a + 1) == 'v' || wholeText.charAt(a + 1) == 'f' || wholeText.charAt(a + 1) == 'u' || a + 1 == wholeText.length()-1)
//					{
//						int count = 0;
//						float[] oneVert = new float[3];
//						for (String str : wholeText.substring(i2, a + 1).split(" "))
//						{
//							if (MODE.DEBUG())
//							{
//								System.out.print(Float.parseFloat(str) + " ");
//							}
//
//							oneVert[count] = Float.parseFloat(str);
//							count++;
//						}
//
//						if (MODE.DEBUG())
//						{
//							System.out.println();
//						}
//
//						vertList.add(new Vertex(oneVert[0], oneVert[1],
//								oneVert[2]));
//						i = a;
//						break;
//					}
//				}
//			} // end get a vertex
//			
//			// get a face
//			if (wholeText.charAt(i) == 'f' && wholeText.charAt(i + 1) == ' ')
//			{
//				i2 = i + 2;
//				for (int a = i2; a < wholeText.length(); a++)
//				{
//
//					if (wholeText.charAt(a) == 'f' || wholeText.charAt(a) == 'v' || wholeText.charAt(a) == 'u' || a == wholeText.length())
//					{
//						int count = 0;
//						int[] oneQuad = new int[4];
//						for (String str : wholeText.substring(i2, a).split(" "))
//						{
//							if (MODE.DEBUG())
//							{
//								System.out.print(Integer.parseInt(str) + " ");
//							}
//
//							oneQuad[count] = Integer.parseInt(str);
//							count++;
//						}
//
//						if (MODE.DEBUG())
//						{
//							System.out.println();
//						}
//
//						quadList.add(new Quad(vertList.get(oneQuad[0] - 1),
//								vertList.get(oneQuad[1] - 1), vertList
//										.get(oneQuad[2] - 1), vertList
//										.get(oneQuad[3] - 1)));
//						
//						i = a - 1;
//						break;
//					}
//				}
//			}// end get a face
//		}
//
//		return quadList.toArray(new Quad[1]);
//	}
//
//	public static Quad[] modelImport(String FileToImport)
//	{
//		ArrayList<Quad> quadList = new ArrayList<Quad>();
//
//		try
//		{
//			String line;
//			ArrayList<Vertex> vertList = new ArrayList<Vertex>();
//
//			BufferedReader dis = new BufferedReader(
//					new FileReader(FileToImport));
//
//			while ((line = dis.readLine()) != null)
//			{
//				if (line.startsWith("v"))
//				{
//					int count = 0;
//					float[] oneVert = new float[3];
//					for (String str : line.substring(2).split(" "))
//					{
//						if (MODE.DEBUG())
//						{
//							System.out.print(Float.parseFloat(str) + " ");
//						}
//
//						oneVert[count] = Float.parseFloat(str);
//						count++;
//					}
//
//					if (MODE.DEBUG())
//					{
//						System.out.println();
//					}
//
//					vertList.add(new Vertex(oneVert[0], oneVert[1], oneVert[2]));
//				}
//
//				if (line.startsWith("f"))
//				{
//					int count = 0;
//					int[] oneQuad = new int[4];
//					for (String str : line.substring(2).split(" "))
//					{
//						if (MODE.DEBUG())
//						{
//							System.out.print(Integer.parseInt(str) + " ");
//						}
//
//						oneQuad[count] = Integer.parseInt(str);
//						count++;
//					}
//
//					if (MODE.DEBUG())
//					{
//						System.out.println();
//					}
//
//					quadList.add(new Quad(vertList.get(oneQuad[0] - 1),
//							vertList.get(oneQuad[1] - 1), vertList
//									.get(oneQuad[2] - 1), vertList
//									.get(oneQuad[3] - 1)));
//				}
//			}
//
//			dis.close();
//
//		}
//		catch (IOException ioe)
//		{
//			ioe.printStackTrace();
//		}
//
//		return quadList.toArray(new Quad[1]);
//	}
	
	public static Triangle[] modelImport3(String FileToImport)
	{
		ArrayList<Vertex> vertList = new ArrayList<Vertex>();
		ArrayList<Triangle> quadList = new ArrayList<Triangle>();
		StringBuilder wholeText = new StringBuilder();

		try
		{

			String line;
			BufferedReader dis = new BufferedReader(
					new FileReader(FileToImport));
			while ((line = dis.readLine()) != null)
			{
				wholeText.append(line);
			}
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i2 = 0;
		for (int i = 0; i < wholeText.length(); i++)
		{
			// get a vertex
			if (wholeText.charAt(i) == 'v' && wholeText.charAt(i + 1) == ' ')
			{
				i2 = i + 2;
				for (int a = i2; a < wholeText.length(); a++)
				{
					if (wholeText.charAt(a + 1) == 'v' || wholeText.charAt(a + 1) == 'f' || wholeText.charAt(a + 1) == 'u' || a + 1 == wholeText.length()-1)
					{
						int count = 0;
						float[] oneVert = new float[3];
						for (String str : wholeText.substring(i2, a + 1).split(" "))
						{
//							if (MODE.DEBUG())
//							{
//								System.out.print(Float.parseFloat(str) + " ");
//							}

							oneVert[count] = Float.parseFloat(str);
							count++;
						}

//						if (MODE.DEBUG())
//						{
//							System.out.println();
//						}

						vertList.add(new Vertex(oneVert[0], oneVert[1],
								oneVert[2]));
						i = a;
						break;
					}
				}
			} // end get a vertex
			
			// get a face
			if (wholeText.charAt(i) == 'f' && wholeText.charAt(i + 1) == ' ')
			{
				i2 = i + 2;
				for (int a = i2; a < wholeText.length(); a++)
				{

					if (wholeText.charAt(a) == 'f' || wholeText.charAt(a) == 'v' || wholeText.charAt(a) == 'u' || a == wholeText.length())
					{
						int count = 0;
						int[] oneTri = new int[3];
						for (String str : wholeText.substring(i2, a).split(" "))
						{
//							if (MODE.DEBUG())
//							{
//								System.out.print(Integer.parseInt(str) + " ");
//							}

							oneTri[count] = Integer.parseInt(str);
							count++;
						}

//						if (MODE.DEBUG())
//						{
//							System.out.println();
//						}

						quadList.add(new Triangle(vertList.get(oneTri[0] - 1),
								vertList.get(oneTri[1] - 1), vertList
										.get(oneTri[2] - 1)));
						
						i = a - 1;
						break;
					}
				}
			}// end get a face
		}

		return quadList.toArray(new Triangle[1]);
	}

	public static void main(String[] args)
	{
		Triangle[]  tList = modelImport3("tricube.obj");
			 for (Triangle q : tList)
			 {
			 System.out.println("Tri:\t" + q.vertices[0].numbers[0] + " "+
			 q.vertices[0].numbers[1] + " " + q.vertices[0].numbers[2] +
			 "\n\t" + q.vertices[1].numbers[0]+ " " + q.vertices[1].numbers[1] +
			 " "+ q.vertices[1].numbers[2] +
			 "\n\t" + q.vertices[2].numbers[0]+ " " + q.vertices[2].numbers[1] +
			 " "+ q.vertices[2].numbers[2]);
			 }
		
//		Quad[] qList = ObjImport.modelImport2("trybox.obj");
//		 for (Quad q : qList)
//		 {
//		 System.out.println("Quad:\t" + q.vertices[0].numbers[0] + " "+
//		 q.vertices[0].numbers[1] + " " + q.vertices[0].numbers[2] +
//		 "\n\t" + q.vertices[1].numbers[0]+ " " + q.vertices[1].numbers[1] +
//		 " "+ q.vertices[1].numbers[2] +
//		 "\n\t" + q.vertices[2].numbers[0]+ " " + q.vertices[2].numbers[1] +
//		 " "+ q.vertices[2].numbers[2] +
//		 "\n\t" + q.vertices[3].numbers[0]+ " " + q.vertices[3].numbers[1] +
//		 " "+ q.vertices[3].numbers[2]);
//		 }
	}
}

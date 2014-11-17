package HeightMap;

import Basic3D.Vector3f;
  /// <summary>
  /// HeightMapInfo is a collection of data about the heightmap. It includes
  /// information about how high the terrain is, and how far apart each vertex is.
  /// It also has several functions to get information about the heightmap, including
  /// its height and normal at different points, and whether a point is on the 
  /// heightmap. It is the runtime equivalent of HeightMapInfoContent.
  /// </summary>
  public class HeightMapInfo
  {


      // TerrainScale is the distance between each entry in the Height property.
      // For example, if TerrainScale is 30, Height[0,0] and Height[1,0] are 30
      // units apart.        
      private float terrainScale;

      // This 2D array of floats tells us the height that each position in the 
      // heightmap is.
      private float[][] heights;

//      private Vector3f[][] normals;

      // the position of the heightmap's -x, -z corner, in worldspace.
      private Vector3f heightmapPosition;

      // the total width of the heightmap, including terrainscale.
      private float heightmapWidth;

      // the total height of the height map, including terrainscale.
      private float heightmapHeight;


      // the constructor will initialize all of the member variables.
      public HeightMapInfo(float[][] heights, float terrainScale) throws Exception
      {
          if (heights == null)
          {
              throw new Exception("heights");
          }
//          if (normals == null)
//          {
//              throw new Exception("normals");
//          }

          heightmapPosition = new Vector3f();
          
          this.terrainScale = terrainScale;
          this.heights = heights;
//          this.normals = normals;

          heightmapWidth = (heights[0].length - 1) * terrainScale;
          heightmapHeight = (heights[1].length - 1) * terrainScale;

          heightmapPosition.x = -(heights[0].length - 1) / 2.0f * terrainScale;
          heightmapPosition.z = -(heights[1].length - 1) / 2.0f * terrainScale;
      }


      // This function takes in a position, and tells whether or not the position is 
      // on the heightmap.
      public boolean IsOnHeightmap(Vector3f position)
      {
          // first we'll figure out where on the heightmap "position" is...
          Vector3f positionOnHeightmap = Vector3f.sub(position,heightmapPosition);

          // ... and then check to see if that value goes outside the bounds of the
          // heightmap.
          return (positionOnHeightmap.x > 0 &&
              positionOnHeightmap.x < heightmapWidth &&
              positionOnHeightmap.z > 0 &&
              positionOnHeightmap.z < heightmapHeight);
      }

      // This function takes in a position, and has two out parameters: the 
      // heightmap's height and normal at that point. Be careful - this function will 
      // throw an IndexOutOfRangeException if position isn't on the heightmap!        
      public float GetHeightAndNormal
          (Vector3f position, float height, Vector3f normal)
      {
          // the first thing we need to do is figure out where on the heightmap
          // "position" is. This'll make the math much simpler later.
          Vector3f positionOnHeightmap = Vector3f.sub(position,heightmapPosition);

          // we'll use integer division to figure out where in the "heights" array
          // positionOnHeightmap is. Remember that integer division always rounds
          // down, so that the result of these divisions is the indices of the "upper
          // left" of the 4 corners of that cell.
          int left, top;
          left = (int)positionOnHeightmap.x / (int)terrainScale;
          top = (int)positionOnHeightmap.x / (int)terrainScale;

          // next, we'll use modulus to find out how far away we are from the upper
          // left corner of the cell. Mod will give us a value from 0 to terrainScale,
          // which we then divide by terrainScale to normalize 0 to 1.
          float xNormalized = (positionOnHeightmap.x % terrainScale) / terrainScale;
          float zNormalized = (positionOnHeightmap.z % terrainScale) / terrainScale;

          // Now that we've calculated the indices of the corners of our cell, and
          // where we are in that cell, we'll use bilinear interpolation to calculuate
          // our height. This process is best explained with a diagram, so please see
          // the accompanying doc for more information.
          // First, calculate the heights on the bottom and top edge of our cell by
          // interpolating from the left and right sides.
          float topHeight = MathHelper.Lerp(
              heights[left][ top],
              heights[left + 1][ top],
              xNormalized);

          float bottomHeight = MathHelper.Lerp(
              heights[left][ top + 1],
              heights[left + 1][ top + 1],
              xNormalized);

          // next, interpolate between those two values to calculate the height at our
          // position.
          height = MathHelper.Lerp(topHeight, bottomHeight, zNormalized);

          // We'll repeat the same process to calculate the normal.
//          Vector3f topNormal = Vector3f.Lerp(
//              normals[left][ top],
//              normals[left + 1][ top],
//              xNormalized);

//          Vector3f bottomNormal = Vector3f.Lerp(
//              normals[left][ top + 1],
//              normals[left + 1][ top + 1],
//              xNormalized);

//          normal = Vector3f.Lerp(topNormal, bottomNormal, zNormalized);
          normal.Normalize();
          
          // TODO Normal too!
          return height;
      }
      
      public static void main(String[] args)
      {
    	  float[][] heights = {{1f, 2f, 3f, 4,5,6},{2f,1,3,4,4, 9},{1f, 2f, 3f, 4,5,6},{2f,1,3,4,4, 9},{1f, 2f, 3f, 4,5,6},{2f,1,3,4,4, 9}};
    	  try
		{
			HeightMapInfo hmap = new HeightMapInfo(heights, 1);
			System.out.println("On thing: " + hmap.GetHeightAndNormal(new Vector3f(2,4,3), 2, new Vector3f(1,2,3)));
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
  }


// TODO need to implement a map reader
//  /// <summary>
//  /// This class will load the HeightMapInfo when the game starts. This class needs 
//  /// to match the HeightMapInfoWriter.
//  /// </summary>
//  public class HeightMapInfoReader : ContentTypeReader<HeightMapInfo>
//  {
//      protected override HeightMapInfo Read(ContentReader input,
//          HeightMapInfo existingInstance)
//      {
//          float terrainScale = input.ReadSingle();
//          int width = input.ReadInt32();
//          int height = input.ReadInt32();
//          float[,] heights = new float[width, height];
//          Vector3[,] normals = new Vector3[width, height];
//
//          for (int x = 0; x < width; x++)
//          {
//              for (int z = 0; z < height; z++)
//              {
//                  heights[x, z] = input.ReadSingle();
//              }
//          }
//          for (int x = 0; x < width; x++)
//          {
//              for (int z = 0; z < height; z++)
//              {
//                  normals[x, z] = input.ReadVector3();
//              }
//          }
//          return new HeightMapInfo(heights, normals, terrainScale);
//      }
//  }
  
  


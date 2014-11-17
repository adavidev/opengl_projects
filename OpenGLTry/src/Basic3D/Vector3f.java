package Basic3D;

public class Vector3f
{
	public float x, y, z;
	
	public Vector3f()
	{
		this(0f,0f,0f);
	}
	
	public Vector3f(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public static Vector3f add(Vector3f p1, Vector3f p2)
	{
		return add(p1, p2.x,p2.y,p2.z);
	}
	
	public static Vector3f add(Vector3f p1, float ox, float oy, float oz)
	{
		return new Vector3f(p1.x + ox, p1.y + oy,p1.z + oz);
	}
	
	public static Vector3f sub(Vector3f p1, Vector3f p2)
	{
		return new Vector3f(p1.x - p2.x, p1.y - p2.y,p1.z - p2.z);
	}
	
	public static Vector3f mult(Vector3f p1, Vector3f p2)
	{
		return new Vector3f(p1.x * p2.x, p1.y * p2.y,p1.z * p2.z);
	}
	
	public static Vector3f mult(Vector3f p1, float scalar)
	{
		return new Vector3f(p1.x * scalar, p1.y * scalar,p1.z * scalar);
	}
	
	 public static Vector3f cross(Vector3f v1, Vector3f v2)
	 {
		 return cross(v1.x,v1.y,v1.z,v2.x,v2.y,v2.z);
	 }
	
	/**
     * <code>cross</code> calculates the cross product of this vector with a
     * parameter vector v.  The result is stored in <code>result</code>
     *
     * @param otherX
     *            x component of the vector to take the cross product of with this.
     * @param otherY
     *            y component of the vector to take the cross product of with this.
     * @param otherZ
     *            z component of the vector to take the cross product of with this.
     * @param result
     *            the vector to store the cross product result.
     * @return result, after recieving the cross product vector.
     */
    public static Vector3f cross(float thisX, float thisY, float thisZ, float otherX, float otherY, float otherZ) {
        float resX = ((thisY * otherZ) - (thisZ * otherY)); 
        float resY = ((thisZ * otherX) - (thisX * otherZ));
        float resZ = ((thisX * otherY) - (thisY * otherX));
        return new Vector3f(resX, resY, resZ);
    }
    
    /**
     * <code>length</code> calculates the magnitude of this vector.
     *
     * @return the length or magnitude of the vector.
     */
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    /**
     * <code>lengthSquared</code> calculates the squared value of the
     * magnitude of the vector.
     *
     * @return the magnitude squared of the vector.
     */
    public float lengthSquared() {
        return x * x + y * y + z * z;
    }

    /**
     * <code>distanceSquared</code> calculates the distance squared between
     * this vector and vector v.
     *
     * @param v the second vector to determine the distance squared.
     * @return the distance squared between the two vectors.
     */
    public float distanceSquared(Vector3f v) {
        double dx = x - v.x;
        double dy = y - v.y;
        double dz = z - v.z;
        return (float) (dx * dx + dy * dy + dz * dz);
    }

    /**
     * <code>distance</code> calculates the distance between this vector and
     * vector v.
     *
     * @param v the second vector to determine the distance.
     * @return the distance between the two vectors.
     */
    public float distance(Vector3f v) {
        return (float) Math.sqrt(distanceSquared(v));
    }
    
    /**
    *
    * <code>dot</code> calculates the dot product of this vector with a
    * provided vector. If the provided vector is null, 0 is returned.
    *
    * @param vec
    *            the vector to dot with this vector.
    * @return the resultant dot product of this vector and a given vector.
    */
   public float dot(Vector3f vec) {
       if (null == vec) {
           return 0;
       }
       return x * vec.x + y * vec.y + z * vec.z;
   }
   
   /**
    * <code>crossLocal</code> calculates the cross product of this vector
    * with a parameter vector v.
    *
    * @param v
    *            the vector to take the cross product of with this.
    * @return this.
    */
   public Vector3f crossLocal(Vector3f v) {
       return crossLocal(v.x, v.y, v.z);
   }

   /**
    * <code>crossLocal</code> calculates the cross product of this vector
    * with a parameter vector v.
    *
    * @param otherX
    *            x component of the vector to take the cross product of with this.
    * @param otherY
    *            y component of the vector to take the cross product of with this.
    * @param otherZ
    *            z component of the vector to take the cross product of with this.
    * @return this.
    */
   public Vector3f crossLocal(float otherX, float otherY, float otherZ) {
       float tempx = ( y * otherZ ) - ( z * otherY );
       float tempy = ( z * otherX ) - ( x * otherZ );
       z = (x * otherY) - (y * otherX);
       x = tempx;
       y = tempy;
       return this;
   }

public static Vector3f Lerp(Vector3f vector3f, Vector3f vector3f2,
		float xNormalized)
{
	// TODO Auto-generated method stub
	return null;
}

public void Normalize()
{
	// TODO Auto-generated method stub
	
}
}

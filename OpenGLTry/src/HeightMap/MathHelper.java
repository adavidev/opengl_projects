package HeightMap;

public class MathHelper
{
	// y = m(x - Px) + Py
	public static float Lerp(float f1, float f2, float xNormalized)
	{
		
		return (f1 - f2) * xNormalized;
	}

}

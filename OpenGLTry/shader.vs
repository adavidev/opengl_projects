
varying vec2 texCoord;
 
void main()
{
        vec2 Position;
        Position.xy = sign(gl_Vertex.xy);
        
        gl_Position = vec4(Position.xy, 0.0, 1.0);
        texCoord = Position.xy *.5 + .5;
	gl_FrontColor  = gl_Color;
	gl_TexCoord[0] = gl_MultiTexCoord0;
}
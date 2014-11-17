uniform sampler2D texture; 
uniform float new_w, new_h, palette;  

varying vec2 texCoord; 
  
vec4 pixelate(sampler2D tex, vec2 uv) {         
	vec2 coord = vec2( ceil(uv.x * 32) / 32,         
	ceil(uv.y * 32) / 32 );         
	return texture2D(tex, coord); 
}   
vec4 reduce_palette(vec4 color, float max_colors_per_channel) {         
	if(max_colors_per_channel < 0) {                 
		return color;         
	}                  
	return ceil(color * max_colors_per_channel) / max_colors_per_channel; 
}   
void main() {         
	vec4 color = pixelate(texture, texCoord);         
	gl_FragColor = reduce_palette(color, palette); 
}
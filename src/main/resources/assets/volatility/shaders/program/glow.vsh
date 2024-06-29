#version 150

// Attributes
in vec3 Position;
in vec2 TexCoord0;

// Uniforms
uniform mat4 projMat;
uniform mat4 modelViewMat;

// Outputs
out vec2 texCoord;

void main() {
    // Transform the vertex position by the model-view and projection matrices
    gl_Position = projMat * modelViewMat * vec4(Position, 1.0);
    // Pass the texture coordinates to the fragment shader
    texCoord = TexCoord0;
}
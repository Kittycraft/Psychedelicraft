package net.ivorius.psychedelicraft.client.rendering;

/**
 * Created by lukas on 03.03.14.
 */
public interface ShaderWorld
{
    public boolean isShaderActive();

    public boolean activate(float partialTicks, float ticks);

    public void deactivate();

    public void setTexture2DEnabled(boolean enabled);

    public void setLightmapEnabled(boolean enabled);

    public void setBlendFunc(int func);

    public void setOverrideColor(float[] color);

    public void setGLLightEnabled(boolean enabled);

    public void setGLLight(int number, float x, float y, float z, float strength, float specular);

    public void setGLLightAmbient(float strength);

    public void setFogMode(int mode);

    public void setFogEnabled(boolean enabled);

    public void setDepthMultiplier(float depthMultiplier);

    public void setUseScreenTexCoords(boolean enabled);

    public void setPixelSize(float pixelWidth, float pixelHeight);

    public void setProjectShadows(boolean projectShadows);
}

package net.ivorius.psychedelicraft.client.rendering;

import net.ivorius.psychedelicraft.toolkit.IvOpenGLTexturePingPong;
import net.ivorius.psychedelicraft.toolkit.IvShaderInstance2D;
import net.minecraft.util.MathHelper;
import org.apache.logging.log4j.Logger;

/**
 * Created by lukas on 18.02.14.
 */
public class ShaderBloom extends IvShaderInstance2D
{
    public float bloom;

    public ShaderBloom(Logger logger)
    {
        super(logger);
    }

    @Override
    public boolean shouldApply(float ticks)
    {
        return bloom > 0.0f && super.shouldApply(ticks);
    }

    @Override
    public void apply(int screenWidth, int screenHeight, float ticks, IvOpenGLTexturePingPong pingPong)
    {
        useShader();

        for (int i = 0; i < 1; i++)
        {
            setUniformInts("tex" + i, i);
        }

        setUniformFloats("pixelSize", 1.0f / screenWidth, 1.0f / screenHeight);

        for (int n = 0; n < MathHelper.floor_double(bloom) + 1; n++)
        {
            for (int i = 0; i < 2; i++)
            {
                float activeBloom = bloom - n;
                if (activeBloom > 1.0f)
                {
                    activeBloom = 1.0f;
                }

                setUniformInts("vertical", i);
                setUniformFloats("totalAlpha", activeBloom);

                drawFullScreen(screenWidth, screenHeight, pingPong);
            }
        }

        stopUsingShader();
    }
}

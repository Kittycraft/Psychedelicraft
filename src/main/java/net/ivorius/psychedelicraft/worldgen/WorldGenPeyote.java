package net.ivorius.psychedelicraft.worldgen;

import java.util.Random;

import net.ivorius.psychedelicraft.blocks.ModBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPeyote extends WorldGenerator
{
    public WorldGenPeyote(boolean notify)
    {
        super(notify);
    }

    @Override
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        if (par1World.isAirBlock(par3, par4, par5))
        {
            int meta = par2Random.nextInt(4);

            if (ModBlocks.blockPeyote.canBlockStay(par1World, par3, par4, par5))
            {
                setBlockAndNotifyAdequately(par1World, par3, par4, par5, ModBlocks.blockPeyote, meta);
            }
        }

        return true;
    }
}

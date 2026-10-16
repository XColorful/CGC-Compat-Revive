package dev.xcolorful.cgccompat.revive.forge;

import dev.xcolorful.cgccompat.revive.CgccRevive;
import dev.xcolorful.cgccompat.revive.forgeclient.CgccReviveForgeClient;
import dev.xcolorful.customgun.core.api.common.McSide;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLLoader;

@Mod(CgccRevive.MOD_ID)
public class CgccReviveForge {

    public CgccReviveForge() {
        Dist dist = FMLLoader.getDist();
        McSide mcSide = dist.isClient() ? McSide.CLIENT : McSide.DEDICATED_SERVER;

        CgccRevive.init();

        if (mcSide == McSide.CLIENT) {
            _CgccReviveForgeClient.init();
        }
    }

    private static class _CgccReviveForgeClient {
        public static void init() {
            CgccReviveForgeClient.init();
        }
    }
}

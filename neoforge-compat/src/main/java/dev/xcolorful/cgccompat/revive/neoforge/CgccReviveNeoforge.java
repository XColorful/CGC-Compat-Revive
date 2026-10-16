package dev.xcolorful.cgccompat.revive.neoforge;

import dev.xcolorful.cgccompat.revive.CgccRevive;
import dev.xcolorful.cgccompat.revive.neoforgeclient.CgccReviveNeoforgeClient;
import dev.xcolorful.customgun.core.api.common.McSide;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.loading.FMLPaths;

@Mod(CgccRevive.MOD_ID)
public class CgccReviveNeoforge {

    public CgccReviveNeoforge(IEventBus modEventBus) {
        Dist dist = FMLLoader.getCurrent().getDist();
        McSide mcSide = dist.isClient() ? McSide.CLIENT : McSide.DEDICATED_SERVER;

        CgccRevive.init(mcSide,
                FMLPaths.GAMEDIR.get(), FMLPaths.CONFIGDIR.get());

        if (mcSide == McSide.CLIENT) {
            _CgccReviveNeoforgeClient.init();
        }
    }

    private static class _CgccReviveNeoforgeClient {
        public static void init() {
            CgccReviveNeoforgeClient.init();
        }
    }
}

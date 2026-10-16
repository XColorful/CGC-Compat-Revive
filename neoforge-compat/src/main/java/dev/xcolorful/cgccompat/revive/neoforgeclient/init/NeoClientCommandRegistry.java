package dev.xcolorful.cgccompat.revive.neoforgeclient.init;

import dev.xcolorful.cgccompat.revive.CgccRevive;
import dev.xcolorful.cgccompat.revive.client.init.ClientCommandRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;

@EventBusSubscriber(value = Dist.CLIENT, modid = CgccRevive.MOD_ID)
public class NeoClientCommandRegistry {

    private static final ClientCommandRegistry CLIENT_COMMAND_REGISTRY = ClientCommandRegistry.get();

    @SubscribeEvent
    public static void onClientCommandsRegister(RegisterClientCommandsEvent event) {
        CLIENT_COMMAND_REGISTRY.registerClientCommands(event.getDispatcher());
    }
}

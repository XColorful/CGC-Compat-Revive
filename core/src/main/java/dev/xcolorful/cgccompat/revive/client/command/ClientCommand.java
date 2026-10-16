package dev.xcolorful.cgccompat.revive.client.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.xcolorful.cgccompat.revive.client.command.sub._ConfigCommand;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

import static dev.xcolorful.cgccompat.revive.client.command.ClientCommandArg.MOD_ID;

public class ClientCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(get(MOD_ID));
    }

    public static LiteralArgumentBuilder<CommandSourceStack> get(String rootName) {
        LiteralArgumentBuilder<CommandSourceStack> root = Commands.literal(rootName);
        root.then(_ConfigCommand.getDisableBleedingShoot()
        );
        root.then(_ConfigCommand.getDisableBleedingReload()
        );
        root.then(_ConfigCommand.getDisableBleedingSwitchFireMode()
        );
        root.then(_ConfigCommand.getDisableBleedingMelee()
        );
        return root;
    }
}

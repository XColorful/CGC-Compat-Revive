package dev.xcolorful.cgccompat.revive.core.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.xcolorful.cgccompat.revive.core.command.sub.ConfigCommand;
import dev.xcolorful.customgun.core.api.minecraft.CommandLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

import static dev.xcolorful.cgccompat.revive.core.command.CommandArg.MOD_ID;

public class ServerCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(get(MOD_ID));
    }

    public static LiteralArgumentBuilder<CommandSourceStack> get(String rootName) {
        LiteralArgumentBuilder<CommandSourceStack> root = Commands.literal(rootName);
        root.then(ConfigCommand.getDisableBleedingShoot()
                .requires(CommandLevel.hasPermission(2))
        );
        root.then(ConfigCommand.getDisableBleedingReload()
                .requires(CommandLevel.hasPermission(2))
        );
        root.then(ConfigCommand.getDisableBleedingSwitchFireMode()
                .requires(CommandLevel.hasPermission(2))
        );
        root.then(ConfigCommand.getDisableBleedingMelee()
                .requires(CommandLevel.hasPermission(2))
        );
        return root;
    }
}

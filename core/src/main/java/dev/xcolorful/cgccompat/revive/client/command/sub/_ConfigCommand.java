package dev.xcolorful.cgccompat.revive.client.command.sub;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import dev.xcolorful.cgccompat.revive.client.CgccReviveClient;
import dev.xcolorful.cgccompat.revive.client.config.CgccReviveClientConfig;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

import static dev.xcolorful.cgccompat.revive.client.command.ClientCommandArg.*;

public class _ConfigCommand {

    public static LiteralArgumentBuilder<CommandSourceStack> getDisableBleedingShoot() {
        return Commands.literal(DISABLE_BLEEDING_SHOOT)
                .then(Commands.argument(BOOL, BoolArgumentType.bool())
                        .executes(_ConfigCommand::setDisableBleedingShoot));
    }
    public static LiteralArgumentBuilder<CommandSourceStack> getDisableBleedingReload() {
        return Commands.literal(DISABLE_BLEEDING_RELOAD)
                .then(Commands.argument(BOOL, BoolArgumentType.bool())
                        .executes(_ConfigCommand::setDisableBleedingReload));
    }
    public static LiteralArgumentBuilder<CommandSourceStack> getDisableBleedingSwitchFireMode() {
        return Commands.literal(DISABLE_BLEEDING_SWITCH_FIRE_MODE)
                .then(Commands.argument(BOOL, BoolArgumentType.bool())
                        .executes(_ConfigCommand::setDisableBleedingSwitchFireMode));
    }
    public static LiteralArgumentBuilder<CommandSourceStack> getDisableBleedingMelee() {
        return Commands.literal(DISABLE_BLEEDING_MELEE)
                .then(Commands.argument(BOOL, BoolArgumentType.bool())
                        .executes(_ConfigCommand::setDisableBleedingMelee));
    }

    private static int setDisableBleedingShoot(CommandContext<CommandSourceStack> context) {
        CgccReviveClientConfig.INSTANCE.disableBleedingShoot = BoolArgumentType.getBool(context, BOOL);
        CgccReviveClient.saveConfig();
        return Command.SINGLE_SUCCESS;
    }
    private static int setDisableBleedingReload(CommandContext<CommandSourceStack> context) {
        CgccReviveClientConfig.INSTANCE.disableBleedingReload = BoolArgumentType.getBool(context, BOOL);
        CgccReviveClient.saveConfig();
        return Command.SINGLE_SUCCESS;
    }
    private static int setDisableBleedingSwitchFireMode(CommandContext<CommandSourceStack> context) {
        CgccReviveClientConfig.INSTANCE.disableBleedingSwitchFireMode = BoolArgumentType.getBool(context, BOOL);
        CgccReviveClient.saveConfig();
        return Command.SINGLE_SUCCESS;
    }
    private static int setDisableBleedingMelee(CommandContext<CommandSourceStack> context) {
        CgccReviveClientConfig.INSTANCE.disableBleedingMelee = BoolArgumentType.getBool(context, BOOL);
        CgccReviveClient.saveConfig();
        return Command.SINGLE_SUCCESS;
    }
}

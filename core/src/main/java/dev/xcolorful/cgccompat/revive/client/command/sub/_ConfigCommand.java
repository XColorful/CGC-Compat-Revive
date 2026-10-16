package dev.xcolorful.cgccompat.revive.client.command.sub;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import dev.xcolorful.cgccompat.revive.client.CgccReviveClient;
import dev.xcolorful.cgccompat.revive.client.config.CgccReviveClientConfig;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.ApiStatus;

import static dev.xcolorful.cgccompat.revive.client.command.ClientCommandArg.*;

public class _ConfigCommand {

    public static LiteralArgumentBuilder<CommandSourceStack> getDisableBleedingShoot() {
        return Commands.literal(DISABLE_BLEEDING_SHOOT)
                .executes(_ConfigCommand::checkDisableBleedingShoot)
                .then(Commands.argument(BOOL, BoolArgumentType.bool())
                        .executes(_ConfigCommand::setDisableBleedingShoot));
    }
    public static LiteralArgumentBuilder<CommandSourceStack> getDisableBleedingReload() {
        return Commands.literal(DISABLE_BLEEDING_RELOAD)
                .executes(_ConfigCommand::checkDisableBleedingReload)
                .then(Commands.argument(BOOL, BoolArgumentType.bool())
                        .executes(_ConfigCommand::setDisableBleedingReload));
    }
    public static LiteralArgumentBuilder<CommandSourceStack> getDisableBleedingSwitchFireMode() {
        return Commands.literal(DISABLE_BLEEDING_SWITCH_FIRE_MODE)
                .executes(_ConfigCommand::checkDisableBleedingSwitchFireMode)
                .then(Commands.argument(BOOL, BoolArgumentType.bool())
                        .executes(_ConfigCommand::setDisableBleedingSwitchFireMode));
    }
    public static LiteralArgumentBuilder<CommandSourceStack> getDisableBleedingMelee() {
        return Commands.literal(DISABLE_BLEEDING_MELEE)
                .executes(_ConfigCommand::checkDisableBleedingMelee)
                .then(Commands.argument(BOOL, BoolArgumentType.bool())
                        .executes(_ConfigCommand::setDisableBleedingMelee));
    }

    private static int checkDisableBleedingShoot(CommandContext<CommandSourceStack> context) {
        _checkConfig(context, DISABLE_BLEEDING_SHOOT, CgccReviveClientConfig.INSTANCE.disableBleedingShoot);
        return Command.SINGLE_SUCCESS;
    }
    private static int checkDisableBleedingReload(CommandContext<CommandSourceStack> context) {
        _checkConfig(context, DISABLE_BLEEDING_RELOAD, CgccReviveClientConfig.INSTANCE.disableBleedingReload);
        return Command.SINGLE_SUCCESS;
    }
    private static int checkDisableBleedingSwitchFireMode(CommandContext<CommandSourceStack> context) {
        _checkConfig(context, DISABLE_BLEEDING_SWITCH_FIRE_MODE, CgccReviveClientConfig.INSTANCE.disableBleedingSwitchFireMode);
        return Command.SINGLE_SUCCESS;
    }
    private static int checkDisableBleedingMelee(CommandContext<CommandSourceStack> context) {
        _checkConfig(context, DISABLE_BLEEDING_MELEE, CgccReviveClientConfig.INSTANCE.disableBleedingMelee);
        return Command.SINGLE_SUCCESS;
    }

    private static int setDisableBleedingShoot(CommandContext<CommandSourceStack> context) {
        CgccReviveClientConfig.INSTANCE.disableBleedingShoot = BoolArgumentType.getBool(context, BOOL);
        CgccReviveClient.saveConfig();
        _sendSuccess(context, DISABLE_BLEEDING_SHOOT, CgccReviveClientConfig.INSTANCE.disableBleedingShoot);
        return Command.SINGLE_SUCCESS;
    }
    private static int setDisableBleedingReload(CommandContext<CommandSourceStack> context) {
        CgccReviveClientConfig.INSTANCE.disableBleedingReload = BoolArgumentType.getBool(context, BOOL);
        CgccReviveClient.saveConfig();
        _sendSuccess(context, DISABLE_BLEEDING_RELOAD, CgccReviveClientConfig.INSTANCE.disableBleedingReload);
        return Command.SINGLE_SUCCESS;
    }
    private static int setDisableBleedingSwitchFireMode(CommandContext<CommandSourceStack> context) {
        CgccReviveClientConfig.INSTANCE.disableBleedingSwitchFireMode = BoolArgumentType.getBool(context, BOOL);
        CgccReviveClient.saveConfig();
        _sendSuccess(context, DISABLE_BLEEDING_SWITCH_FIRE_MODE, CgccReviveClientConfig.INSTANCE.disableBleedingSwitchFireMode);
        return Command.SINGLE_SUCCESS;
    }
    private static int setDisableBleedingMelee(CommandContext<CommandSourceStack> context) {
        CgccReviveClientConfig.INSTANCE.disableBleedingMelee = BoolArgumentType.getBool(context, BOOL);
        CgccReviveClient.saveConfig();
        _sendSuccess(context, DISABLE_BLEEDING_MELEE, CgccReviveClientConfig.INSTANCE.disableBleedingMelee);
        return Command.SINGLE_SUCCESS;
    }

    @ApiStatus.Internal
    private static void _checkConfig(CommandContext<CommandSourceStack> context, String tag, boolean bool) {
        context.getSource().sendSuccess(() -> Component.literal("(client) " + tag + ": " + bool), false);
    }

    @ApiStatus.Internal
    private static void _sendSuccess(CommandContext<CommandSourceStack> context, String tag, boolean bool) {
        context.getSource().sendSuccess(() -> Component.literal("(client) " + tag + " set to " + bool), false);
    }
}

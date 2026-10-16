package dev.xcolorful.cgccompat.revive.core.command.sub;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import dev.xcolorful.cgccompat.revive.CgccRevive;
import dev.xcolorful.cgccompat.revive.core.config.CgccReviveConfig;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.ApiStatus;

import static dev.xcolorful.cgccompat.revive.core.command.CommandArg.*;

public class ConfigCommand {

    public static LiteralArgumentBuilder<CommandSourceStack> getDisableBleedingShoot() {
        return Commands.literal(DISABLE_BLEEDING_SHOOT)
                .executes(ConfigCommand::checkDisableBleedingShoot)
                .then(Commands.argument(BOOL, BoolArgumentType.bool())
                        .executes(ConfigCommand::setDisableBleedingShoot));
    }
    public static LiteralArgumentBuilder<CommandSourceStack> getDisableBleedingReload() {
        return Commands.literal(DISABLE_BLEEDING_RELOAD)
                .executes(ConfigCommand::checkDisableBleedingReload)
                .then(Commands.argument(BOOL, BoolArgumentType.bool())
                        .executes(ConfigCommand::setDisableBleedingReload));
    }
    public static LiteralArgumentBuilder<CommandSourceStack> getDisableBleedingSwitchFireMode() {
        return Commands.literal(DISABLE_BLEEDING_SWITCH_FIRE_MODE)
                .executes(ConfigCommand::checkDisableBleedingSwitchFireMode)
                .then(Commands.argument(BOOL, BoolArgumentType.bool())
                        .executes(ConfigCommand::setDisableBleedingSwitchFireMode));
    }
    public static LiteralArgumentBuilder<CommandSourceStack> getDisableBleedingMelee() {
        return Commands.literal(DISABLE_BLEEDING_MELEE)
                .executes(ConfigCommand::checkDisableBleedingMelee)
                .then(Commands.argument(BOOL, BoolArgumentType.bool())
                        .executes(ConfigCommand::setDisableBleedingMelee));
    }

    private static int checkDisableBleedingShoot(CommandContext<CommandSourceStack> context) {
        _checkConfig(context, DISABLE_BLEEDING_SHOOT, CgccReviveConfig.INSTANCE.disableBleedingShoot);
        return Command.SINGLE_SUCCESS;
    }
    private static int checkDisableBleedingReload(CommandContext<CommandSourceStack> context) {
        _checkConfig(context, DISABLE_BLEEDING_RELOAD, CgccReviveConfig.INSTANCE.disableBleedingReload);
        return Command.SINGLE_SUCCESS;
    }
    private static int checkDisableBleedingSwitchFireMode(CommandContext<CommandSourceStack> context) {
        _checkConfig(context, DISABLE_BLEEDING_SWITCH_FIRE_MODE, CgccReviveConfig.INSTANCE.disableBleedingSwitchFireMode);
        return Command.SINGLE_SUCCESS;
    }
    private static int checkDisableBleedingMelee(CommandContext<CommandSourceStack> context) {
        _checkConfig(context, DISABLE_BLEEDING_MELEE, CgccReviveConfig.INSTANCE.disableBleedingMelee);
        return Command.SINGLE_SUCCESS;
    }

    private static int setDisableBleedingShoot(CommandContext<CommandSourceStack> context) {
        CgccReviveConfig.INSTANCE.disableBleedingShoot = BoolArgumentType.getBool(context, BOOL);
        CgccRevive.saveConfig();
        _sendSuccess(context, DISABLE_BLEEDING_SHOOT, CgccReviveConfig.INSTANCE.disableBleedingShoot);
        return Command.SINGLE_SUCCESS;
    }
    private static int setDisableBleedingReload(CommandContext<CommandSourceStack> context) {
        CgccReviveConfig.INSTANCE.disableBleedingReload = BoolArgumentType.getBool(context, BOOL);
        CgccRevive.saveConfig();
        _sendSuccess(context, DISABLE_BLEEDING_RELOAD, CgccReviveConfig.INSTANCE.disableBleedingReload);
        return Command.SINGLE_SUCCESS;
    }
    private static int setDisableBleedingSwitchFireMode(CommandContext<CommandSourceStack> context) {
        CgccReviveConfig.INSTANCE.disableBleedingSwitchFireMode = BoolArgumentType.getBool(context, BOOL);
        CgccRevive.saveConfig();
        _sendSuccess(context, DISABLE_BLEEDING_SWITCH_FIRE_MODE, CgccReviveConfig.INSTANCE.disableBleedingSwitchFireMode);
        return Command.SINGLE_SUCCESS;
    }
    private static int setDisableBleedingMelee(CommandContext<CommandSourceStack> context) {
        CgccReviveConfig.INSTANCE.disableBleedingMelee = BoolArgumentType.getBool(context, BOOL);
        CgccRevive.saveConfig();
        _sendSuccess(context, DISABLE_BLEEDING_MELEE, CgccReviveConfig.INSTANCE.disableBleedingMelee);
        return Command.SINGLE_SUCCESS;
    }

    @ApiStatus.Internal
    private static void _checkConfig(CommandContext<CommandSourceStack> context, String tag, boolean bool) {
        context.getSource().sendSuccess(() -> Component.literal(tag + ": " + bool), false);
    }

    @ApiStatus.Internal
    private static void _sendSuccess(CommandContext<CommandSourceStack> context, String tag, boolean bool) {
        context.getSource().sendSuccess(() -> Component.literal(tag + " set to " + bool), false);
    }
}

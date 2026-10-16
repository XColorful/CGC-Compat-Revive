package dev.xcolorful.cgccompat.revive.core.command.sub;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import dev.xcolorful.cgccompat.revive.CgccRevive;
import dev.xcolorful.cgccompat.revive.core.config.CgccReviveConfig;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

import static dev.xcolorful.cgccompat.revive.core.command.CommandArg.*;

public class ConfigCommand {

    public static LiteralArgumentBuilder<CommandSourceStack> getDisableBleedingShoot() {
        return Commands.literal(DISABLE_BLEEDING_SHOOT)
                .then(Commands.argument(BOOL, BoolArgumentType.bool())
                        .executes(ConfigCommand::setDisableBleedingShoot));
    }
    public static LiteralArgumentBuilder<CommandSourceStack> getDisableBleedingReload() {
        return Commands.literal(DISABLE_BLEEDING_RELOAD)
                .then(Commands.argument(BOOL, BoolArgumentType.bool())
                        .executes(ConfigCommand::setDisableBleedingReload));
    }
    public static LiteralArgumentBuilder<CommandSourceStack> getDisableBleedingSwitchFireMode() {
        return Commands.literal(DISABLE_BLEEDING_SWITCH_FIRE_MODE)
                .then(Commands.argument(BOOL, BoolArgumentType.bool())
                        .executes(ConfigCommand::setDisableBleedingSwitchFireMode));
    }
    public static LiteralArgumentBuilder<CommandSourceStack> getDisableBleedingMelee() {
        return Commands.literal(DISABLE_BLEEDING_MELEE)
                .then(Commands.argument(BOOL, BoolArgumentType.bool())
                        .executes(ConfigCommand::setDisableBleedingMelee));
    }

    private static int setDisableBleedingShoot(CommandContext<CommandSourceStack> context) {
        CgccReviveConfig.INSTANCE.disableBleedingShoot = BoolArgumentType.getBool(context, BOOL);
        CgccRevive.saveConfig();
        return Command.SINGLE_SUCCESS;
    }
    private static int setDisableBleedingReload(CommandContext<CommandSourceStack> context) {
        CgccReviveConfig.INSTANCE.disableBleedingReload = BoolArgumentType.getBool(context, BOOL);
        CgccRevive.saveConfig();
        return Command.SINGLE_SUCCESS;
    }
    private static int setDisableBleedingSwitchFireMode(CommandContext<CommandSourceStack> context) {
        CgccReviveConfig.INSTANCE.disableBleedingSwitchFireMode = BoolArgumentType.getBool(context, BOOL);
        CgccRevive.saveConfig();
        return Command.SINGLE_SUCCESS;
    }
    private static int setDisableBleedingMelee(CommandContext<CommandSourceStack> context) {
        CgccReviveConfig.INSTANCE.disableBleedingMelee = BoolArgumentType.getBool(context, BOOL);
        CgccRevive.saveConfig();
        return Command.SINGLE_SUCCESS;
    }
}

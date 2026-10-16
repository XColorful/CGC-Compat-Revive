package dev.xcolorful.cgccompat.revive.core.mixin.playerrevive;

import dev.xcolorful.cgccompat.revive.core.config.CgccReviveConfig;
import dev.xcolorful.customgun.core.compat.playerrevive.PlayerReviveCompat;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import team.creative.playerrevive.api.IBleeding;
import team.creative.playerrevive.server.PlayerReviveServer;

import java.util.List;

@Mixin(PlayerReviveCompat.class)
public class PlayerReviveCompatMixin {

    @Inject(method = "isBleeding", at = @At("HEAD"), cancellable = true, remap = false)
    private static void cgcc$isBleeding(LivingEntity livingEntity, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(livingEntity instanceof Player player && PlayerReviveServer.isBleeding(player));
    }

    @Inject(method = "revive", at = @At("HEAD"), cancellable = true, remap = false)
    private static void cgcc$revive(LivingEntity livingEntity, CallbackInfo ci) {
        if (livingEntity instanceof Player player) PlayerReviveServer.revive(player);
        ci.cancel();
    }

    @Inject(method = "kill", at = @At("HEAD"), cancellable = true, remap = false)
    private static void cgcc$kill(LivingEntity livingEntity, CallbackInfo ci) {
        if (livingEntity instanceof Player player) PlayerReviveServer.kill(player);
        ci.cancel();
    }

    @Inject(method = "getRevivingPlayers", at = @At("HEAD"), cancellable = true, remap = false)
    private static void cgcc$getRevivingPlayers(LivingEntity livingEntity, CallbackInfoReturnable<List<Player>> cir) {
        if (!(livingEntity instanceof Player player)) {
            cir.setReturnValue(null);
            return;
        }

        IBleeding bleeding = PlayerReviveServer.getBleeding(player);
        cir.setReturnValue(bleeding == null ? null : bleeding.revivingPlayers());
    }

    @Inject(method = "shouldDisableShoot", at = @At("HEAD"), cancellable = true, remap = false)
    private static void cgcc$shouldDisableShoot(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(CgccReviveConfig.INSTANCE.disableBleedingShoot);
    }
    @Inject(method = "shouldDisableReload", at = @At("HEAD"), cancellable = true, remap = false)
    private static void cgcc$shouldDisableReload(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(CgccReviveConfig.INSTANCE.disableBleedingReload);
    }
    @Inject(method = "shouldDisableSwitchFireMode", at = @At("HEAD"), cancellable = true, remap = false)
    private static void cgcc$shouldDisableSwitchFireMode(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(CgccReviveConfig.INSTANCE.disableBleedingSwitchFireMode);
    }
    @Inject(method = "shouldDisableMelee", at = @At("HEAD"), cancellable = true, remap = false)
    private static void cgcc$shouldDisableMelee(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(CgccReviveConfig.INSTANCE.disableBleedingMelee);
    }
}

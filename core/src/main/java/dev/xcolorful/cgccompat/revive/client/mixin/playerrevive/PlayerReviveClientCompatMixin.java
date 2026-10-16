package dev.xcolorful.cgccompat.revive.client.mixin.playerrevive;

import dev.xcolorful.customgun.client.compat.playerrevive.PlayerReviveClientCompat;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import team.creative.playerrevive.server.PlayerReviveServer;

@Mixin(PlayerReviveClientCompat.class)
public class PlayerReviveClientCompatMixin {

    @Inject(method = "isBleeding", at = @At("HEAD"), cancellable = true, remap = false)
    private static void cgcc$isBleeding(LocalPlayer localPlayer, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(PlayerReviveServer.isBleeding(localPlayer));
    }

    @Inject(method = "shouldDisableShoot", at = @At("HEAD"), cancellable = true, remap = false)
    private static void cgcc$shouldDisableShoot(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
    @Inject(method = "shouldDisableReload", at = @At("HEAD"), cancellable = true, remap = false)
    private static void cgcc$shouldDisableReload(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
    @Inject(method = "shouldDisableSwitchFireMode", at = @At("HEAD"), cancellable = true, remap = false)
    private static void cgcc$shouldDisableSwitchFireMode(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
    @Inject(method = "shouldDisableMelee", at = @At("HEAD"), cancellable = true, remap = false)
    private static void cgcc$shouldDisableMelee(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}

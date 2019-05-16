package abused_master.superores.mixins;

import abused_master.superores.registry.ModBlocks;
import net.minecraft.world.dimension.OverworldDimension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OverworldDimension.class)
public class MixinOverworldDimension {

    @Inject(method = "createChunkGenerator", at = @At("HEAD"))
    private void createChunkGenerator(CallbackInfoReturnable cir) {
        ModBlocks.registerWorldGen();
    }
}

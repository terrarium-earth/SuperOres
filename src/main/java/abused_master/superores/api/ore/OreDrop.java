package abused_master.superores.api.ore;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.Item;

public record OreDrop(Item item, UniformInt dropChance) {

    public static final Codec<OreDrop> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Registry.ITEM.byNameCodec().fieldOf("id").forGetter(OreDrop::item),
            UniformInt.CODEC.fieldOf("rate").orElse(UniformInt.of(1, 2)).forGetter(OreDrop::dropChance)
    ).apply(instance, OreDrop::new));
}

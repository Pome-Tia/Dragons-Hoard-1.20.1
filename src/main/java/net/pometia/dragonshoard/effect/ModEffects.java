package net.pometia.dragonshoard.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pometia.dragonshoard.DragonsHoard;

public class ModEffects {
    public static final StatusEffect FLIGHT = registerStatusEffect("flight",
            new JanAltarEffect(StatusEffectCategory.BENEFICIAL, 0x36ebab));


    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(DragonsHoard.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        DragonsHoard.LOGGER.info("Registering Mod Effects for " + DragonsHoard.MOD_ID);
    }
}

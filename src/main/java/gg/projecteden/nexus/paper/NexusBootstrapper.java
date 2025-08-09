package gg.projecteden.nexus.paper;

import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.bootstrap.PluginProviderContext;
import io.papermc.paper.registry.data.EnchantmentRegistryEntry;
import io.papermc.paper.registry.event.RegistryEvents;
import io.papermc.paper.registry.keys.EnchantmentKeys;
import io.papermc.paper.registry.keys.tags.ItemTypeTagKeys;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("UnstableApiUsage")
public class NexusBootstrapper implements PluginBootstrap {

	@Override
	public void bootstrap(BootstrapContext context) {
		context.getLifecycleManager().registerEventHandler(RegistryEvents.ENCHANTMENT.compose().newHandler(event -> {
			event.registry().register(
				EnchantmentKeys.create(Key.key("nexus:pointy")),
				b -> b.description(Component.text("Pointy"))
					.supportedItems(event.getOrCreateTag(ItemTypeTagKeys.SWORDS))
					.anvilCost(1)
					.maxLevel(25)
					.weight(10)
					.minimumCost(EnchantmentRegistryEntry.EnchantmentCost.of(1, 1))
					.maximumCost(EnchantmentRegistryEntry.EnchantmentCost.of(3, 1))
					.activeSlots(EquipmentSlotGroup.ANY)
			);
		}));
	}

	@Override
	public @NotNull JavaPlugin createPlugin(@NotNull PluginProviderContext context) {
		return new NexusPaper();
	}

}
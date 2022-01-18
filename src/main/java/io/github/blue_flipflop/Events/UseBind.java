package io.github.blue_flipflop.Events;

import io.github.blue_flipflop.ChatBinds;
import io.github.blue_flipflop.Setup.Config;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "chatbinds", value = Dist.CLIENT)
public class UseBind {
	
    @SubscribeEvent
    public static void handleEventInput(ClientTickEvent e) {
    	Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || e.phase == Phase.START)
            return;
        if (ChatBinds.CHATBIND1.consumeClick()) {
        	for (String line : Config.message1.get().split("\n")) {
        		mc.player.chat(line);
        	}
        } else if (ChatBinds.CHATBIND2.consumeClick()) {
        	for (String line : Config.message2.get().split("\n")) {
        		mc.player.chat(line);
        	}
        } else if (ChatBinds.CHATBIND3.consumeClick()) {
        	for (String line: Config.message3.get().split("\n")) {
        		mc.player.chat(line);
        	}
        }
    }
}
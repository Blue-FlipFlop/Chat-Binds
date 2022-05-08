package io.github.blue_flipflop.chatbinds.Events;

import io.github.blue_flipflop.chatbinds.ChatBinds;
import io.github.blue_flipflop.chatbinds.Setup.Config;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import java.util.LinkedList;
import java.util.Queue;

@EventBusSubscriber(modid = "chatbinds", value = Dist.CLIENT)
public class UseBind {
	static Queue<String> toChat = new LinkedList<String>();
	static int currentTick = 1;
    @SubscribeEvent
    public static void handleEventInput(ClientTickEvent e) {
    	Minecraft mc = Minecraft.getInstance();
    	currentTick = (currentTick + 1) % Config.delayTime.get();
        if (mc.player == null || e.phase == Phase.START) {
            return;
        }
        if (ChatBinds.CHATBIND1.consumeClick() && !Config.message1.get().isBlank()) {
        	for (String line : Config.message1.get().split("\n")) {
        		toChat.add(line);
        	}
        } else if (ChatBinds.CHATBIND2.consumeClick() && !Config.message2.get().isBlank()) {
        	for (String line : Config.message2.get().split("\n")) {
        		toChat.add(line);
        	}
        } else if (ChatBinds.CHATBIND3.consumeClick() && !Config.message3.get().isBlank()) {
        	for (String line : Config.message3.get().split("\n")) {
        		toChat.add(line);
        	}
        }
        if (toChat.peek() != null && currentTick == 1) {
        	mc.player.chat(toChat.poll());
        }
    }
}
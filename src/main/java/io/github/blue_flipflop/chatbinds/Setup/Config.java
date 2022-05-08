package io.github.blue_flipflop.chatbinds.Setup;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Config {

    public static final Builder CLIENT_BUILDER = new Builder();

    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ConfigValue<String> message1;
    public static ConfigValue<String> message2;
    public static ConfigValue<String> message3;
    public static ConfigValue<Integer> delayTime;
    
	public static void register() {

    	CLIENT_BUILDER.comment("General").push("Chat Binds");
    	message1 = CLIENT_BUILDER.comment("Message to Display for Chat Bind 1").define("message1", "");
    	message2 = CLIENT_BUILDER.comment("Message to Display for Chat Bind 2").define("message2", "");
    	message3 = CLIENT_BUILDER.comment("Message to Display for Chat Bind 3").define("message3", "");
    	delayTime = CLIENT_BUILDER.comment("Delay Time for Multi-line Messages").define("delayTime", 4);
    	CLIENT_BUILDER.pop();
    	
        CLIENT_CONFIG = CLIENT_BUILDER.build();

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
        
    }

}
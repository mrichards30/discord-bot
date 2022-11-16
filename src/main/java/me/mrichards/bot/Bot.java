package me.mrichards.bot;

import me.mrichards.bot.messagelisteners.MessageLogger;
import me.mrichards.bot.commands.RandomCommands;
import me.mrichards.bot.framework.BotEventsRegistrar;
import me.mrichards.bot.framework.BotEventListeners;
import me.mrichards.bot.messagelisteners.MusicTasteJudger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Bot {

    private static BotEventsRegistrar registrar;

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("pass token as arg");
            System.exit(1);
        }

        JDA jda = JDABuilder.createLight(args[0], GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new BotEventListeners())
                .setActivity(Activity.playing("genshin impact 2"))
                .build();

        registrar = BotEventsRegistrar.of(jda)
                .registerCommand("test", RandomCommands::test, "Say hi")
                .registerCommand("test2", RandomCommands::hi)
                .chainMessageListener(MusicTasteJudger::handle)
                .chainMessageListener(MessageLogger::handle);

    }

    public static BotEventsRegistrar getRegistrar() {
        return registrar;
    }

}

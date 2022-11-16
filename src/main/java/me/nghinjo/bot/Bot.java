package me.nghinjo.bot;

import me.nghinjo.bot.commands.MessageListeners;
import me.nghinjo.bot.commands.RandomCommands;
import me.nghinjo.bot.framework.BotEventsRegistrar;
import me.nghinjo.bot.framework.BotEventListeners;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import java.util.Collections;

public class Bot {

    private static BotEventsRegistrar registrar;

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("pass token as arg");
            System.exit(1);
        }

        JDA jda = JDABuilder.createLight(args[0], Collections.emptyList())
                .addEventListeners(new BotEventListeners())
                .setActivity(Activity.playing("genshin impact 2"))
                .build();

        registrar = BotEventsRegistrar.of(jda)
                .registerCommand("test", RandomCommands::test, "Say hi")
                .registerCommand("test2", RandomCommands::hi)
                .chainMessageListener(MessageListeners::affirmMattsMusicTaste)
                .chainMessageListener(MessageListeners::log);

    }

    public static BotEventsRegistrar getRegistrar() {
        return registrar;
    }

}

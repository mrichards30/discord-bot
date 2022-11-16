package me.mrichards.bot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class RandomCommands {

    public static void test(SlashCommandInteractionEvent event) {
        event.reply("end my suffering").queue();
    }

    public static void hi(SlashCommandInteractionEvent event) {
        event.reply("hi " + event.getName()).queue();
    }

}

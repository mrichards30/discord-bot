package me.nghinjo.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Collections;

public class Bot extends ListenerAdapter {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("pass token as arg");
            System.exit(1);
        }

        JDA jda = JDABuilder.createLight(args[0], Collections.emptyList())
                .addEventListeners(new Bot())
                .setActivity(Activity.playing("genshin impact 2"))
                .build();

        jda.upsertCommand("test", "oh man this is gonna test so hard").queue();
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent command) {
        //TODO chain of responsibility?
        if (command.getName().equals("test")) {
            command.reply("please turn me off i hate being alive").queue();
        }
    }

}

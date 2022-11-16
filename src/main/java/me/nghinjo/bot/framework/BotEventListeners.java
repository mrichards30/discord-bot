package me.nghinjo.bot.framework;

import me.nghinjo.bot.Bot;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class BotEventListeners extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        Bot.getRegistrar().getBotCommands().stream()
                .filter(command -> event.getName().equals(command.getName()))
                .forEach(command -> command.handle(event));
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        System.out.println("debugging is ufn");
        Bot.getRegistrar().getMessageReceivedPipeline().accept(event);
    }

}

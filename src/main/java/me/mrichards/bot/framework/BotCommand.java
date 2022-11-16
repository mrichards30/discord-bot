package me.mrichards.bot.framework;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.util.function.Consumer;

public class BotCommand {

    private final String name;
    private final Consumer<SlashCommandInteractionEvent> consumer;

    private String description;

    public BotCommand(String name, Consumer<SlashCommandInteractionEvent> consumer) {
        this.name = name;
        this.consumer = consumer;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void handle(SlashCommandInteractionEvent event) {
        this.consumer.accept(event);
    }

}

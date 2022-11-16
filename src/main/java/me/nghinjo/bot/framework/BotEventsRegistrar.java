package me.nghinjo.bot.framework;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BotEventsRegistrar {

    private final JDA jda;
    private final List<BotCommand> commands = new ArrayList<>();

    private Consumer<MessageReceivedEvent> messageReceivedPipeline;

    private BotEventsRegistrar(JDA jda) {
        this.jda = jda;
    }

    public static BotEventsRegistrar of(JDA jda) {
        return new BotEventsRegistrar(jda);
    }

    public BotEventsRegistrar registerCommand(String name, Consumer<SlashCommandInteractionEvent> consumer) {
        commands.add(new BotCommand(name, consumer));
        jda.upsertCommand(name, name).queue();
        return this;
    }

    public BotEventsRegistrar registerCommand(String name, Consumer<SlashCommandInteractionEvent> consumer, String description) {
        BotCommand command = new BotCommand(name, consumer);
        command.setDescription(description);
        commands.add(command);
        jda.upsertCommand(name, description).queue();
        return this;
    }

    public BotEventsRegistrar chainMessageListener(Consumer<MessageReceivedEvent> consumer) {
        messageReceivedPipeline = messageReceivedPipeline == null ? consumer : messageReceivedPipeline.andThen(consumer);
        return this;
    }

    public Consumer<MessageReceivedEvent> getMessageReceivedPipeline() {
        return this.messageReceivedPipeline;
    }

    public List<BotCommand> getBotCommands() {
        return this.commands;
    }

}

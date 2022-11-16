package me.mrichards.bot.messagelisteners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class MessageLogger {

    // More of a proof of concept class... delete once we get the point.

    public static void handle(MessageReceivedEvent event) {
        System.out.println(event.getAuthor().getName() + " said: " + event.getMessage().getContentRaw());
    }

}

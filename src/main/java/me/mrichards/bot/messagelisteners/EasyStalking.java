package me.mrichards.bot.messagelisteners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class EasyStalking {

    public static void log(MessageReceivedEvent event) {
        System.out.println(event.getAuthor().getName() + " said " + event.getMessage().getContentRaw());
    }

}

package me.nghinjo.bot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class MessageListeners {

    public static void affirmMattsMusicTaste(MessageReceivedEvent event) {
        if (event.getAuthor().getName().equals("Matt") &&
                event.getChannel().getIdLong() == 412438443231281162L &&
                event.getMessage().getEmbeds().stream().anyMatch(embed -> embed.getUrl() != null)) {
            event.getMessage().reply("matt you have such good taste its insane").queue();
        }
    }

    public static void log(MessageReceivedEvent event) {
        System.out.println(event.getAuthor().getName() + " said " + event.getMessage().getContentRaw());
    }

}

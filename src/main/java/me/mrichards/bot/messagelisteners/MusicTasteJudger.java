package me.mrichards.bot.messagelisteners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class MusicTasteJudger {

    private static boolean shouldHandle(MessageReceivedEvent event) {
        return event.getChannel().getIdLong() != 412438443231281162L ||
                event.getMessage().getEmbeds().stream().noneMatch(embed -> embed.getUrl() != null);
    }

    public static void handle(MessageReceivedEvent event) {
        if (!shouldHandle(event)) return;
        event.getMessage().reply(event.getAuthor().getName().equals("Matt") ?
                "matt you have such good taste its insane" :
                "oh yikes").queue();
    }

}

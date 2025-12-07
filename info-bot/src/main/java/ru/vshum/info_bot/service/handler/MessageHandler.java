package ru.vshum.info_bot.service.handler;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.vshum.info_bot.telegram.Bot;

public class MessageHandler implements UpdateHandler {
    @Override
    public BotApiMethod<?> answer(Update update, Bot bot) {
        return null;
    }
}

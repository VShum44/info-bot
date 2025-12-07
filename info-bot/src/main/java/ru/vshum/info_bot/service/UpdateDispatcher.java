package ru.vshum.info_bot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.vshum.info_bot.service.handler.CallbackQueryHandler;
import ru.vshum.info_bot.service.handler.CommandHandler;
import ru.vshum.info_bot.service.handler.MessageHandler;
import ru.vshum.info_bot.telegram.Bot;

@Service
@RequiredArgsConstructor
public class UpdateDispatcher {

    private final CallbackQueryHandler callbackQueryHandler;
    private final MessageHandler messageHandler;
    private final CommandHandler commandHandler;

    public BotApiMethod<?> distribute(Update update, Bot bot) {
        if (update.hasCallbackQuery()) {
            return callbackQueryHandler.answer(update, bot);
        }
        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                return commandHandler.answer(update, bot);
            }
        return messageHandler.answer(update, bot);
        }
        return null;
    }
}

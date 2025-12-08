package ru.vshum.info_bot.service.handler;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.vshum.info_bot.telegram.Bot;

@Service
public class CommandHandler implements UpdateHandler {
    @Override
    public BotApiMethod<?> answer(Update update, Bot bot) {
        String messageText = update.getMessage().getText();
        return switch (messageText) {
            case "/start" -> handleStart(update);
            default -> defaultAnswer(update);
        };
    }

    private BotApiMethod<?> handleStart(Update update) {
        return SendMessage.builder()
                .chatId(update.getMessage().getChatId())
                .text("""
                        Привет! Я информационный бот.
                        Могу рассказать о погоде или курсах валют.
                        """)
                .build();
    }

    private BotApiMethod<?> defaultAnswer(Update update) {
        return SendMessage.builder()
                .chatId(update.getMessage().getChatId())
                .text("""
                        Я не знаю такой команды.
                        Напиши /start, чтобы узнать мои возможности.
                        """)
                .build();
    }
}

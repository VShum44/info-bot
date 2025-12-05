package ru.vshum.info_bot.telegram;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class Bot extends TelegramWebhookBot {

    private final TelegramProperties telegramProperties;

    public Bot(TelegramProperties telegramProperties) {
        super(telegramProperties.getToken());
        this.telegramProperties = telegramProperties;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return SendMessage.builder()
                .chatId(update.getMessage().getChatId())
                .text(update.getMessage().getText())
                .build();
    }

    @Override
    public String getBotPath() {
        return telegramProperties.getPath();
    }

    @Override
    public String getBotUsername() {
        return telegramProperties.getUsername();
    }
}

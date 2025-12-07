package ru.vshum.info_bot.telegram;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.vshum.info_bot.service.UpdateDispatcher;

@Component
public class Bot extends TelegramWebhookBot {

    private final TelegramProperties telegramProperties;
    private final UpdateDispatcher updateDispatcher;

    public Bot(TelegramProperties telegramProperties,
               UpdateDispatcher updateDispatcher) {
        super(telegramProperties.getToken());
        this.telegramProperties = telegramProperties;
        this.updateDispatcher = updateDispatcher;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return updateDispatcher.distribute(update, this);
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

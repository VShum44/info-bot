package ru.vshum.info_bot;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.vshum.info_bot.telegram.Bot;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final Bot bot;

    @PostMapping("/")
    public BotApiMethod<?> listener(@RequestBody Update update) {
        return bot.onWebhookUpdateReceived(update);
    }

    private BotApiMethod<?> echo(Message message) {
        return SendMessage.builder()
                .chatId(message.getChatId())
                .text(message.getText())
                .build();
    }
}

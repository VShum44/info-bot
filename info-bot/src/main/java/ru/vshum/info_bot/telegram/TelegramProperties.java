package ru.vshum.info_bot.telegram;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegram-bot")
public class TelegramProperties {

    private String token;
    private String username;
    private String path;

    public void setToken(String token) {
        log.info("set token {}", token.substring(0,5));
        this.token = token;
    }

    public void setUsername(String username) {
        log.info("set username {}", username);
        this.username = username;
    }

    public void setPath(String path) {
        log.info("set path {}", path);
        this.path = path;
    }
}

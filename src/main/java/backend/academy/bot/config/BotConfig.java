package backend.academy.bot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public record BotConfig(String telegramToken) {
    public String telegramToken() {
        return telegramToken.replaceAll("^\"|\"$", "");
    }
}
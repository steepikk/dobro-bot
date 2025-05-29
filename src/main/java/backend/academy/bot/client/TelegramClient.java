package backend.academy.bot.client;

import backend.academy.bot.config.BotConfig;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TelegramClient {
    private final TelegramBot bot;

    public TelegramClient(BotConfig botConfig) {
        this.bot = new TelegramBot(botConfig.telegramToken());
    }

    public void sendMessage(Long chatId, String message) {
        SendMessage request = new SendMessage(chatId, message);
        SendResponse response = bot.execute(request);

        if (response.isOk()) {
            log.info("Message sent successfully to chat {}: {}", chatId, message);
        } else {
            log.info("Message sent failed: {}", response.description());
        }
    }
}

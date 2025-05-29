package backend.academy.bot.listener;

import backend.academy.bot.config.BotConfig;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class TelegramBotListener {
    private final TelegramBot bot;

    public TelegramBotListener(BotConfig config) {
        this.bot = new TelegramBot(config.telegramToken());
    }

    @PostConstruct
    public void init() {
        bot.setUpdatesListener(updates -> {
            for (Update update : updates) {
                if (update.message() != null && update.message().text() != null) {
                    Long chatId = update.message().chat().id();
                    String incomingText = update.message().text();

                    log.info("Получено сообщение: {}", incomingText);

                    SendMessage response = new SendMessage(chatId, "добро");
                    bot.execute(response);
                }
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}

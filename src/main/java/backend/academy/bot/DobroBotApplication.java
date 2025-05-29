package backend.academy.bot;

import backend.academy.bot.config.BotConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(BotConfig.class)
@SpringBootApplication
public class DobroBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(DobroBotApplication.class, args);
    }

}

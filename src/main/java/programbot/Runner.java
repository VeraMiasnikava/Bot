package programbot;

import lombok.extern.log4j.Log4j;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import programbot.bot.Bot;
import programbot.dao.CreaterDB;



@Log4j
public class Runner {
    public static void main(String[] args) {

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        Bot bot = new Bot();
        try {
            telegramBotsApi.registerBot(bot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

        CreaterDB createrDB = new CreaterDB();
        createrDB.create();

        System.out.println("программа запущена");

    }
}

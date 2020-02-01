package programbot.bot;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import programbot.dao.UserDaoImpl;
import programbot.entities.User;

@Log4j
public class Bot extends TelegramLongPollingBot {

    private Action action = new Action();
    private SendMessage sendMessage = new SendMessage();

    public Bot() {
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {

        if (update.getMessage() != null) {
            UserDaoImpl userDao = new UserDaoImpl();
            User user = userDao.findById(update.getMessage().getChatId());
            if (user == null) {
                user = new User(update.getMessage().getChatId(), 0);
                userDao.save(user);
            }
            sendMessage = action.action0(update, user);
            executeMessage();
        } else if (update.hasCallbackQuery()) {
            UserDaoImpl userDao = new UserDaoImpl();
            User user = userDao.findById(update.getCallbackQuery().getMessage().getChatId());
            if (user != null) {
                int state = user.getState();
                switch (state) {
                    case 0:
                        sendMessage.setText("enter /start");
                        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                        break;
                    case 1:
                        sendMessage = action.action1(update);
                        break;
                    case 2:
                        sendMessage = action.action2(update, user);
                        break;
                    case 3:
                        sendMessage = action.action3(update, user);
                        break;
                }
                executeMessage();
            }
        }

    }

    public void executeMessage() {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Error TelegramApi:");
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "@VfProgramBot";
    }

    @Override
    public String getBotToken() {
        return "961984795:AAEGwwMaMKTzy101IqNbxMndPOcTCl9X23s";
    }
}

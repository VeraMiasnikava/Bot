package programbot.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    private String message;

    public Bot() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void onUpdateReceived(Update update) {
        update.getUpdateId();
        SendMessage sendMessage=new SendMessage().setChatId(update.getMessage().getChatId());

        if(update.getMessage().getText().equalsIgnoreCase("Hello")){
            sendMessage.setText(message);
            try{
                execute(sendMessage);
            }catch(TelegramApiException e){
               e.printStackTrace();
            }
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

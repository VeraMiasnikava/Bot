package programbot.bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import programbot.dao.GroupDaoImpl;
import programbot.dao.StudentDaoImpl;
import programbot.dao.UserDaoImpl;
import programbot.entities.Group;
import programbot.entities.User;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Action {

    private String message;

    public SendMessage action0(Update update, User user) throws UnsupportedEncodingException {
        String text = "";
        update.getUpdateId();
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        if (update.getMessage().hasText()) {
            text = update.getMessage().getText();
        }
        if (text.equalsIgnoreCase("/start")) {
            message = new String("выберите дисциплину:".getBytes("cp1251"), "UTF-8");
            sendMessage.setText(message);
            setDisciplinesInlineKeyboard(sendMessage);
            user = new User(update.getMessage().getChatId(), 1);
            UserDaoImpl userDao = new UserDaoImpl();
            userDao.update(user);
        } else {
            boolean isDigit;
            Long idStudent = 0L;
            try {
                idStudent = Long.parseLong(text);
                isDigit = true;
            } catch (NumberFormatException e) {
                isDigit = false;
            }
            if (isDigit && user.getState() == 4) {
                message = actionDiscipline(user, idStudent);
                sendMessage.setText(message);
                user = new User(update.getMessage().getChatId(), 0, 0);
                UserDaoImpl userDao = new UserDaoImpl();
                userDao.update(user);
            } else {
                user = new User(update.getMessage().getChatId(), 0);
                UserDaoImpl userDao = new UserDaoImpl();
                userDao.update(user);
                message = "no such command, enter /start";
                sendMessage.setText(message);
            }
        }
        return sendMessage;
    }

    private void setDisciplinesInlineKeyboard(SendMessage sendMessage) {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        buttons1.add(new InlineKeyboardButton().setText("Programming").setCallbackData("1"));
        buttons.add(buttons1);
         /*
        List<InlineKeyboardButton> buttons2 = new ArrayList<>();
        buttons2.add(new InlineKeyboardButton().setText("Information").setCallbackData("2"));
        buttons.add(buttons2);
        */
        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttons);
        sendMessage.setReplyMarkup(markupKeyboard);
    }

    public SendMessage action1(Update update) throws UnsupportedEncodingException {
        String text = "";
        int numberOfDiscipine = 0;
        update.getUpdateId();
        SendMessage sendMessage = new SendMessage().setChatId(update.getCallbackQuery().getMessage().getChatId());
        text = update.getCallbackQuery().getData();
        numberOfDiscipine = Integer.parseInt(text);
        String t = new String("выберите группу:".getBytes("cp1251"), "UTF-8");
        message = t;
        sendMessage.setText(message);
        setGroupsInlineKeyboard(sendMessage);
        User user = new User(update.getCallbackQuery().getMessage().getChatId(), 2, numberOfDiscipine);
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.update(user);

        return sendMessage;
    }

    private void setGroupsInlineKeyboard(SendMessage sendMessage) {
        GroupDaoImpl groupDao = new GroupDaoImpl();
        List<Group> groups = groupDao.findAll();

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        for (Iterator<Group> it = groups.iterator(); it.hasNext(); ) {
            Group group = (Group) it.next();
            System.out.println("gr=" + group.getGroupTitle());
            List<InlineKeyboardButton> buttons1 = new ArrayList<>();
            buttons1.add(new InlineKeyboardButton().setText(group.getGroupTitle()).setCallbackData(group.getGroupTitle()));
            buttons.add(buttons1);
        }

        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttons);
        sendMessage.setReplyMarkup(markupKeyboard);
    }

    public SendMessage action2(Update update, User user) throws UnsupportedEncodingException {
        String groupTitle = "";
        update.getUpdateId();
        SendMessage sendMessage = new SendMessage().setChatId(update.getCallbackQuery().getMessage().getChatId());
        groupTitle = update.getCallbackQuery().getData();
        String t = new String("выберите действие:".getBytes("cp1251"), "UTF-8");
        message = t;
        sendMessage.setText(message);
        setActsInlineKeyboard(sendMessage);
        User user1 = new User(update.getCallbackQuery().getMessage().getChatId(), 3, user.getNumberOfDiscipline(), groupTitle);
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.update(user1);
        return sendMessage;
    }

    private void setActsInlineKeyboard(SendMessage sendMessage) throws UnsupportedEncodingException {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        String t = new String("узнать id учащегося".getBytes("cp1251"), "UTF-8");
        buttons1.add(new InlineKeyboardButton().setText(t).setCallbackData("act1"));
        buttons.add(buttons1);

        List<InlineKeyboardButton> buttons2 = new ArrayList<>();
        t = new String("просмотреть оценки учащегося по id ".getBytes("cp1251"), "UTF-8");
        buttons2.add(new InlineKeyboardButton().setText(t).setCallbackData("act2"));
        buttons.add(buttons2);

        List<InlineKeyboardButton> buttons3 = new ArrayList<>();
        t = new String("просмотреть задолженности группы".getBytes("cp1251"), "UTF-8");
        buttons3.add(new InlineKeyboardButton().setText(t).setCallbackData("act3"));
        buttons.add(buttons3);

        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttons);
        sendMessage.setReplyMarkup(markupKeyboard);
    }

    public SendMessage action3(Update update, User user) throws UnsupportedEncodingException {
        update.getUpdateId();
        SendMessage sendMessage = new SendMessage().setChatId(update.getCallbackQuery().getMessage().getChatId());
        String act = update.getCallbackQuery().getData();
        if (act.equalsIgnoreCase("act1")) {
            StudentDaoImpl studentDao = new StudentDaoImpl();
            message = studentDao.findStudentsByGroup(user.getGroupTitle());
            message = message + String.format("%n-------------------------%n");
            String t = new String("введите id учащегося:".getBytes("cp1251"), "UTF-8");
            message = message + t;
            user = new User(update.getCallbackQuery().getMessage().getChatId(), 4, user.getNumberOfDiscipline(), user.getGroupTitle());
            UserDaoImpl userDao = new UserDaoImpl();
            userDao.update(user);
        } else if (act.equalsIgnoreCase("act3")) {
            StudentDaoImpl studentDao = new StudentDaoImpl();
            message = studentDao.findDebtsProgrammingByGroup(user.getGroupTitle());
            user = new User(update.getCallbackQuery().getMessage().getChatId(), 0, 0);
            UserDaoImpl userDao = new UserDaoImpl();
            userDao.update(user);
        } else if (act.equalsIgnoreCase("act2")) {
            message = new String("введите id учащегося:".getBytes("cp1251"), "UTF-8");
            user = new User(update.getCallbackQuery().getMessage().getChatId(), 4, user.getNumberOfDiscipline(), user.getGroupTitle());
            UserDaoImpl userDao = new UserDaoImpl();
            userDao.update(user);
        } else {
            message = new String("no action".getBytes("cp1251"), "UTF-8");
        }
        sendMessage.setText(message);
        return sendMessage;
    }

    public String actionDiscipline(User user, Long idStudent) throws UnsupportedEncodingException {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        switch (user.getNumberOfDiscipline()) {
            case 1:
                return studentDao.findProgrammingLessonsByStudentId(idStudent);
            default:
                return "no information found";
        }
    }
}

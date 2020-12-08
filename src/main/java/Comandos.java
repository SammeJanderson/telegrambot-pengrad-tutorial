import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.List;

//Vamos adiconar um teclado para o nosso bot

public class Comandos {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot("");


        bot.setUpdatesListener(new UpdatesListener() {

            public int process(List<Update> updates) {

                for (Update update : updates) {
                    String command = update.message().text();
                    Long chatId = update.message().chat().id();
                    BaseResponse baseResponse;
                    SendResponse sendResponse;

                    switch (command) {
                        case "/nome":
                            baseResponse = bot.execute(new SendChatAction(chatId, ChatAction.typing));
                            sendResponse = bot.execute(new SendMessage(chatId, update.message().from().firstName()));
                            break;
                        case "/sobrenome":
                            baseResponse = bot.execute(new SendChatAction(chatId, ChatAction.typing));
                            sendResponse = bot.execute(new SendMessage(chatId, update.message().from().lastName()));
                            break;
                        default:
                            baseResponse = bot.execute(new SendChatAction(chatId, ChatAction.typing));
                            sendResponse = bot.execute(new SendMessage(chatId, "Não entendi por favor use um comando"));
                            break;

                    }
                }
                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }

        });


    }
}

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.List;

//Vamos adiconar um teclado para o nosso bot

public class __InlineKeyboardMarkup{
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot("");

        Keyboard keyboard =  new ReplyKeyboardMarkup(
                new String[]{"nome","sobrenome","o que é Telegram?"}
        ).resizeKeyboard(true);


        InlineKeyboardMarkup keyboard2 = new InlineKeyboardMarkup(
                new InlineKeyboardButton[]{
                        new InlineKeyboardButton("Telegram").url("https://telegram.org/"),

                });




        bot.setUpdatesListener(new UpdatesListener() {

            public int process(List<Update> updates) {

                for (Update update : updates) {
                    String command = update.message().text();
                    Long chatId = update.message().chat().id();
                    BaseResponse baseResponse;
                    SendResponse sendResponse;

                    switch (command) {
                        case "nome":
                            baseResponse = bot.execute(new SendChatAction(chatId, ChatAction.typing));
                            sendResponse = bot.execute(new SendMessage(chatId, update.message().from().firstName()));
                            break;
                        case "sobrenome":
                            baseResponse = bot.execute(new SendChatAction(chatId, ChatAction.typing));
                            sendResponse = bot.execute(new SendMessage(chatId, update.message().from().lastName()));
                            break;
                            case "o que é Telegram?":
                            baseResponse = bot.execute(new SendChatAction(chatId, ChatAction.typing));
                            sendResponse = bot.execute(new SendMessage(chatId, "Você pode descobrir mais aqui").replyMarkup(keyboard2));
                            break;
                        default:
                            baseResponse = bot.execute(new SendChatAction(chatId, ChatAction.typing));
                            sendResponse = bot.execute(new SendMessage(chatId, "Não entendi por favor use um comando").replyMarkup(keyboard));
                            break;

                    }
                }
                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }

        });


    }
}

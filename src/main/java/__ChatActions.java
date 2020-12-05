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

public class __ChatActions {
    public static void main(String[] args) {
        TelegramBot sammeTesteBot = new TelegramBot("");




        sammeTesteBot.setUpdatesListener(new UpdatesListener() {

            @Override
            public int process(List<Update> list) {
                for (Update update : list) {
                    BaseResponse response =  sammeTesteBot.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing));
                    SendResponse sendResponse = sammeTesteBot.execute(new SendMessage(update.message().chat().id(), update.message().text()));

                    System.out.println(update.message().from().firstName() + " :" + update.message().text());

                }


                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });


    }
}

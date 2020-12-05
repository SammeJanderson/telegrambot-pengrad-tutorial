import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.List;

//Vamos adiconar um teclado para o nosso bot

public class __KeyBoardButton {
    public static void main(String[] args) {
        TelegramBot sammeTesteBot = new TelegramBot("");

        //criamos nosso botão
        Keyboard keyboard = new ReplyKeyboardMarkup(
                new KeyboardButton[]{
                        new KeyboardButton("text"),
                        new KeyboardButton("contact").requestContact(true),
                        new KeyboardButton("location").requestLocation(true)
                }
        );


        sammeTesteBot.setUpdatesListener(new UpdatesListener() {

            @Override
            public int process(List<Update> list) {
                for (Update update : list) {
                    SendResponse sendResponse = sammeTesteBot.execute(new SendMessage(update.message().chat().id(),
                            update.message().text()).replyMarkup(keyboard));//anexamos nosso teclado no fim da menssagem

                    System.out.println(update.message().from().firstName() + " :" + update.message().text());

                }


                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });


    }
}

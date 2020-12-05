import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.List;

//Vamos adiconar um teclado para o nosso bot

public class __InlineKeyboardMarkup {
    public static void main(String[] args) {
        TelegramBot sammeTesteBot = new TelegramBot("");

        //criamos nosso inline
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton[]{
                        new InlineKeyboardButton("url").url("www.google.com"),
                        new InlineKeyboardButton("callback_data").callbackData("callback_data"),
                        new InlineKeyboardButton("Switch!").switchInlineQuery("switch_inline_query")
                });


        sammeTesteBot.setUpdatesListener(new UpdatesListener() {

            @Override
            public int process(List<Update> list) {
                for (Update update : list) {
                    SendMessage message =  new SendMessage(update.message().chat().id(),"escolha uma opção")
                            .parseMode(ParseMode.Markdown)
                            .replyMarkup(inlineKeyboard);
                    sammeTesteBot.execute(message);

                    System.out.println(update.message().from().firstName() + " :" + update.message().text());

                }


                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });


    }
}

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.List;

public class EchoBot {
    public static void main(String[] args) {
        //registra o bot
        TelegramBot bot = new TelegramBot("");


        //recebe todos os updates
        bot.setUpdatesListener(new UpdatesListener() {

            //lista de todos os updates
            @Override
            public int process(List<Update> list) {
                //intera os updates
                for (Update update : list) {

                    //manda a resposta para o usuario
                    SendResponse sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
                            update.message().text()));

                    //printa a menssagem no console
                    System.out.println(update.message().from().firstName() + " :" + update.message().text());

                }


                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });


    }
}

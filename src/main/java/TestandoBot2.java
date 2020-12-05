import com.pengrad.telegrambot.TelegramBot;

import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.List;


public class TestandoBot2 {
    public static void main(String[] args) {

        TelegramBot sammeTesteBot = new TelegramBot("");
        int offset = 1;




        sammeTesteBot.setUpdatesListener(new UpdatesListener() {
            SendResponse sendResponse;




            @Override
            public int process(List<Update> list) {
                String command = "";

                for (Update update : list) {
                    command = update.message().text();

                    if (command.equals("samme")) {
                        System.out.println(update.message().text());
                        sendResponse = sammeTesteBot
                                .execute(new SendMessage(update.message().chat().id(), "Sim sou incrivel"));

                    } else {
                        sendResponse = sammeTesteBot.execute(new SendMessage(update.message().chat().id(), update.message().text()));

                    }


                }


                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });


    }



}

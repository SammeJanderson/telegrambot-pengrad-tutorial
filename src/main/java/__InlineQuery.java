import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.ChosenInlineResult;
import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.AnswerInlineQuery;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.List;


public class __InlineQuery {
    public static void main(String[] args) {
        TelegramBot sammeTesteBot = new TelegramBot("");


        sammeTesteBot.setUpdatesListener(new UpdatesListener() {

            @Override
            public int process(List<Update> list) {
                for (Update update : list) {

                    InlineQuery inlineQuery = update.inlineQuery();
                    ChosenInlineResult chosenInlineResult = update.chosenInlineResult();
                    CallbackQuery callbackQuery = update.callbackQuery();

                    String message = update.inlineQuery().query();

                    InlineQueryResult inlineQueryResult = new InlineQueryResultArticle("id","Bot do samme",message + " query").thumbUrl("https://avatars0.githubusercontent.com/u/71139904?s=460&u=053e4ab44af4d7e1dfff928a7478f63d63553186&v=4");

                    BaseResponse response = sammeTesteBot.execute(new AnswerInlineQuery(inlineQuery.id(), inlineQueryResult));

                    System.out.println(message);









                }


                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });







    }
}

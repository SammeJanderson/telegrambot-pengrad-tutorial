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
        TelegramBot bot = new TelegramBot("");


        bot.setUpdatesListener(new UpdatesListener() {
            @Override
            public int process(List<Update> list) {
                for (Update update : list) {

                    InlineQuery inlineQuery = update.inlineQuery();
                    ChosenInlineResult chosenInlineResult = update.chosenInlineResult();
                    CallbackQuery callbackQuery = update.callbackQuery();

                    if (inlineQuery != null) {
                        String menssagem = new StringBuilder(inlineQuery.query()).reverse().toString();


                        InlineQueryResult inlineQueryResult = new InlineQueryResultArticle("id", "Inline Query exemplo", menssagem)
                                .thumbUrl("https://cdn0.iconfinder.com/data/icons/social-network-24/512/Telegram-512.png");

                        BaseResponse baseResponse = bot.execute(new AnswerInlineQuery((inlineQuery.id()), inlineQueryResult));


                    }

                }


                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }

        });


    }
}

/*package ru.progwards.dpb;

//import org.telegram.telegrambots.ApiContextInitializer;
import ru.progwards.java1.telegrambot.ProgwardsTelegramBot;

public class PizzaBot extends ProgwardsTelegramBot {
    private final String menu = "У нас есть пицца";


    @Override
    public String processMessage(String text) {
        checkTags(text);
        if (foundCount() == 1) {
            if (checkLastFound("привет"))
                return "Я вас категорически приветствую!\n Что будем заказывать? ";
            if (checkLastFound("конец"))
                return "Спасибо за заказ.";
            return "Отлично, добавляю в заказ " + getLastFound() + " Желаешь что-то еще?";
        }
        if (foundCount() > 1)
            return "Под твой запрос подходит: \n" + extract() + "Выбери что-то одно, и я добавлю это в заказ.";
        return "Я не понял, возможно у нас этого нет, попробуй сказать по другому. ";
    }
    public static void main(String[] args) {
        System.out.println("Hello bot");
        ApiContextInitializer.init();
        PizzaBot bot = new PizzaBot();
        bot.username = "pizza93rusbot";
        bot.token = "1036571829:AAGqxkVb_yoHIllyaPgm7G-hVgpk_RnwUqI";

        bot.addTags("привет", "привет, здрасьте, здравствуй, добр, день, вечер, утро, hi, hello");
        bot.addTags("конец", "конец, все, стоп, нет");
//-----


        bot.addTags("Пицца гавайская", "гавайск, пицц, ананас, куриц");
        bot.addTags("Пицца маргарита", "маргарит, пицц, моцарелла, сыр, кетчуп, помидор");
        bot.addTags("Пицца пеперони", "пеперони, пицц, салями, колбас, сыр, кетчуп, помидор");
        bot.addTags("Торт тирамису", "десерт, кофе, маскарпоне, бисквит");
        bot.addTags("Торт медовик", "десерт, мед, бисквит");
        bot.addTags("Эклеры", "десерт, заварной, крем, тесто");

        bot.addTags("Кола", "напит, пить, кола");
        bot.addTags("Холодный чай", "напит, пить, чай, липтон, лимон");
        bot.addTags("Сок", "напит, пить, сок, апельсиноый, яблочный, вишневый");
        bot.start();
    }
}*/

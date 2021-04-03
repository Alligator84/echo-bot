import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EchoBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "YurrencyFundsBot";
    }

    @Override
    public String getBotToken() {
        return "";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message incomingMessage = update.getMessage();
            SendMessage outgoingMessage = new SendMessage();
            outgoingMessage.setChatId(incomingMessage.getChatId().toString());
            outgoingMessage.setText(incomingMessage.getText());
            try {
                execute(outgoingMessage);
            } catch (TelegramApiException ex) {
                System.err.println("Error echo-bot");
            }
        }
    }
}

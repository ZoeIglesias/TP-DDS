package enviadoresNotificaciones;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class EnviadorTelegram {
    private static final String BOT_TOKEN = "6983055296:AAGjGPZWP5hTv1u7OsQ-x4j0U0sdhmWCIdg";
    private static final String CHAT_ID = "6376858170";
    private static EnviadorTelegram instancia = null;

    private EnviadorTelegram() {}

    public static EnviadorTelegram getInstance() {
        if(instancia == null)
            instancia = new EnviadorTelegram();
        return instancia;
    }

    public void enviar_telegram(String message) {
        OkHttpClient client = new OkHttpClient();

        String url = String.format(
                "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s",
                BOT_TOKEN,
                CHAT_ID,
                message
        );

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

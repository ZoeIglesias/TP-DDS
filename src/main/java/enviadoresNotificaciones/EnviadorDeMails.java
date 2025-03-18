package enviadoresNotificaciones;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class EnviadorDeMails {
    private static final String apiKey = "8bb512fbbd1b3fffdcdcf7b652983f41-0f1db83d-89ff12b0";
    private static final String dominio = "sandboxda9cc0224a2b47a4af52164bcf2d6b84.mailgun.org";
    private static EnviadorDeMails instancia = null;

    private EnviadorDeMails() {}

    public static EnviadorDeMails getInstance() {
        if(instancia == null)
            instancia = new EnviadorDeMails();
        return instancia;
    }

    public void enviar_email(String from, String to, String subject, String text) {
        HttpResponse<String> response = Unirest.post("https://api.mailgun.net/v3/" + dominio + "/messages")
                .basicAuth("api", apiKey)
                .field("from", from)
                .field("to", to)
                .field("subject", subject)
                .field("text", text)
                .asString();

        System.out.println(response.getBody());
    }
}

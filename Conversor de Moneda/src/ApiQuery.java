import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiQuery {

    double getExchangeRate(String from, String to) {

        String apiKey = "7e9e956d9fcffe747ef054b8";
        URI url = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + from + "/" + to + "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        HttpResponse<String> response;


            try {
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

                if (json.get("result").getAsString().equals("success")) {
                    return json.get("conversion_rate").getAsDouble();
                }else {
                    System.out.println("Error en la respuesta: " + json);
                }

            } catch (IOException | InterruptedException e) {
                System.out.println("Error al obtener datps de la API: " + e.getMessage());
            }
        return 0;
    }
}

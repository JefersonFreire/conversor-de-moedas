package br.com.jeferson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeApiClient {

     private static final String api_key = System.getenv("API_KEY");

    public String getBody(String baseCurrency, String targetCurrency) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/pair/"+baseCurrency+"/"+targetCurrency;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + api_key)
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}

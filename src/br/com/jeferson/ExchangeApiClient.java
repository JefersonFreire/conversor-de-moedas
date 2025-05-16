package br.com.jeferson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeApiClient {

     private static final String api_key = System.getenv("API_KEY");

    public String getBody(String baseCurrency, String targetCurrency, double amount) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/"+api_key+"/pair/"+baseCurrency+"/"+targetCurrency+"/"+amount;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}

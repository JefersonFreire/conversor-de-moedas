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
        try {
            if(api_key == null || api_key.isBlank()){
                throw new IllegalStateException("API_KEY não definida no ambiente.");
            }
            String url = "https://v6.exchangerate-api.com/v6/"+api_key+"/pair/"+baseCurrency+"/"+targetCurrency+"/"+amount;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/json")
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() != 200){
                throw new IOException("Erro na API: Código " +response.statusCode());
            }
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao conectar com o servidor de câmbio: " + e.getMessage());
            throw e;
        }
    }
}

package br.com.jeferson;

import java.io.IOException;

public class ExchangeApiService {

    private final ExchangeApiClient apiClient;
    private final CurrencyJsonParser parser;

    public ExchangeApiService(ExchangeApiClient apiClient, CurrencyJsonParser parser) {
        this.apiClient = apiClient;
        this.parser = parser;
    }

    public Currency convertCurrency(String baseCode, String targetCode, double amount) throws IOException, InterruptedException {
        String response = apiClient.getBody(baseCode, targetCode, amount);
        return parser.getJson(response);
    }

}

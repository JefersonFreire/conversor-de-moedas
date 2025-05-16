package br.com.jeferson;

import java.io.IOException;

public class ExchangeApiService {

        private final ExchangeApiClient apiClient;
        private final JsonParser parser;

        public ExchangeApiService(ExchangeApiClient apiClient, JsonParser parser) {
            this.apiClient = apiClient;
            this.parser = parser;
        }

    public Currency exchangeApiConverter(String baseCode, String targetCode, double amount) throws IOException, InterruptedException {
        String response = apiClient.getBody(baseCode, targetCode, amount);
        return parser.getJson(response);
    }
}

package br.com.jeferson;

import com.google.gson.Gson;

public class CurrencyJsonParser {
    public Currency getJson(String json)  {
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, Currency.class);
        } catch (Exception e) {
            System.err.println("Erro ao converter os dados da API: " +e.getMessage());
            return null;
        }
    }
}

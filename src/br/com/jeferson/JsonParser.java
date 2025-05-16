package br.com.jeferson;

import com.google.gson.Gson;

public class JsonParser {
    public Currency getJson(String json)  {
        Gson gson = new Gson();
        return gson.fromJson(json, Currency.class);
    }
}

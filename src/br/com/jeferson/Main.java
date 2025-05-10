package br.com.jeferson;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        ExchangeApiClient client = new ExchangeApiClient();

        System.out.println(client.getBody("BRL","USD"));

    }
}

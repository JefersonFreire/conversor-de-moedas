package br.com.jeferson;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();

        ExchangeApiClient client = new ExchangeApiClient();
        JsonParser parser = new JsonParser();

        ExchangeApiService service = new ExchangeApiService(client, parser);
        Currency currency = service.exchangeApiConverter("USD","BRL",amount);


    }
}

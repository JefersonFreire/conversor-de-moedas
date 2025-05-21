package br.com.jeferson;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int options = 0;

        while (options != 7) {

            System.out.print("""
                ------------------------------------------------------------
                Conversor de Moedas         
                ------------------------------------------------------------  
                1) Dólar ==> Real
                2) Real ==> Dólar 
                3) Dólar Canadense ==> Real
                4) Real ==> Peso Agentino
                5) Real ==> Dólar Australiano
                6) Real ==> Euro
                7) Sair
                ------------------------------------------------------------
                Escolha uma opção válida:
                ------------------------------------------------------------
                """
            );
            try {
                options = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Tente novamente.");
                sc.next();
            }

            switch (options) {
                case 1:
                    apiConverter("USD","BRL",inAmount(sc));
                    break;
                case 2: ;
                    apiConverter("BRL","USD",inAmount(sc));
                    break;
                case 3:
                    apiConverter("CAD","BRL",inAmount(sc));
                    break;
                case 4:
                    apiConverter("BRL","ARS",inAmount(sc));
                    break;
                case 5:
                    apiConverter("BRL","AUD",inAmount(sc));
                    break;
                case 6:
                    apiConverter("BRL","EUR",inAmount(sc));
                    break;
                case 7:
                    options = 7;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Insira uma opção válida!");
            }
        }

    }
    public static Currency apiConverter(String base, String target, double amount) {
        ExchangeApiClient client = new ExchangeApiClient();
        CurrencyJsonParser parser = new CurrencyJsonParser();
        ExchangeApiService service = new ExchangeApiService(client, parser);

        try {
            Currency currency = service.convertCurrency(base, target, amount);
            if (currency != null) {
                double converted = currency.converterAmount(amount);
                System.out.printf("O valor de %.2f %s corresponde ao valor final de %.2f %s\n", amount, base, converted, target);
                return currency;
            } else {
                System.out.println("Erro na conversão. Verifique os dados.");
            }
        } catch (Exception e) {
            System.out.println("Erro inesperado durante a conversão: " + e.getMessage());
        }
        return null;
    }

    public static double inAmount(Scanner in) {
        while(true) {
            System.out.print("""
                    ------------------------------------------------------------
                    Digite o valor que deseja realizar a conversão:
                    ------------------------------------------------------------
                    """);
            try {
                return in.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Digite um número válido (ex: 10,50).");
                in.next();
            }
        }
    }
}

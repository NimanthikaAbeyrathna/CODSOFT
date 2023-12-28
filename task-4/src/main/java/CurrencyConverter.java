import org.json.JSONObject;

import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base currency code (e.g. USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency code (e.g. LKR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        BigDecimal exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        System.out.print("Enter the amount to convert: ");
        BigDecimal amountToConvert = scanner.nextBigDecimal();

        BigDecimal convertedAmount = amountToConvert.multiply(exchangeRate);

        System.out.printf("%.2f %s is equal to %.2f %s%n",
                amountToConvert, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }

    private static BigDecimal getExchangeRate(String baseCurrency, String targetCurrency) {

        try {

            String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;
            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject rates = jsonResponse.getJSONObject("rates");
            double exchangeRate = rates.getDouble(targetCurrency);

            return BigDecimal.valueOf(exchangeRate);

        } catch (Exception e) {
            System.err.println("Error fetching exchange rates: " + e.getMessage());
            return BigDecimal.ZERO;
        }
    }
}

package com.saracoglu;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;

public class WeatherAPICall {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        // API URL oluşturduk
        Config config = new Config();
        String apiKey = config.getApiKey();
        String baseURL = config.getBaseURL();
        String city = GetCity.getCityName();
        String date = GetDate.getDateInfo();
        String time = GetTime.getTimeInfo();

        String urlString = String.format("%s%s/%sT%s?key=%s", baseURL, city, date, time, apiKey);
        try {
            // URL oluşturma
            URI uri = new URI(urlString);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET"); // GET isteği
            connection.setRequestProperty("Accept", "application/json"); // Veri formatı

            // Yanıt kodunu kontrol etme
            int responseCode = connection.getResponseCode();


            // Yanıtı okuma
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JsonNode jsonNode = objectMapper.readTree(response.toString());

                // JSON Node'u WeatherData sınıfına dönüştürün
                WeatherData weatherData = objectMapper.treeToValue(jsonNode, WeatherData.class);

                // Verileri kullanın
                for (WeatherData.Day day : weatherData.getDays()) {
                    for (WeatherData.Hour hour : day.getHours()) {
                        if (hour.getDatetime().equals(time)) {
                            System.out.printf("Saatlik sıcaklık: %.2f%n", (hour.getTemp() - 32) / 1.8);
                            System.out.printf("Saatlik nem: %.2f%n", hour.getHumidity());
                            System.out.printf("Saatlik durum: %s%n", hour.getConditions());
                        }
                    }
                }
            } else {
                System.out.println("GET request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

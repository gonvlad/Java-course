package by.gsu.lab9;

import by.gsu.pms.Forecast;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Runner {
    public static final String URL = "http://api.openweathermap.org/data/2.5/weather?q=Kiev,ua&appid=d46c47eac54879f975bcbe5c18c24353&units=metric";

    public static void main(String[] args) {
        Gson gson = new Gson();
        Forecast forecast = null;
        try {
            URL url = new URL(URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.addRequestProperty("User-Agent", "Chrome");
            InputStreamReader reader = new InputStreamReader(httpURLConnection.getInputStream());
            forecast = gson.fromJson(reader, Forecast.class);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (forecast != null) {
            System.out.println("\nНазвание города: " + forecast.getName() +
                                "\nКод страны: " + forecast.getSys().getCountry() +
                                "\nКраткое описание погоды: " + forecast.getWeather()[0].getMain() +
                                "\nПолное описание погоды: " + forecast.getWeather()[0].getDescription() +
                                "\nТекущая температура в градусах Цельсия: " + forecast.getMain().getTemp() +
                                "\nДавление в мм ртутного столба: " + forecast.getMain().getPressure() +
                                "\nВлажность в процентах: " + forecast.getMain().getHumidity() +
                                "\nМинимальная и максимальная температура за сегодня: " + forecast.getMain().getTemp_min() + forecast.getMain().getTemp_max() +
                                "\nСкорость и направление ветра (Пример: 3 m/s SW):" + forecast.getWind().getSpeed() + forecast.getWind().getDeg() +
                                "\nОблачность в процентах: " + forecast.getClouds().getAll());
        }

    }
}

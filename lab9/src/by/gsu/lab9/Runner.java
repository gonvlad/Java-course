package by.gsu.lab9;

import by.gsu.pms.Forecast;
import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Runner {
    public static final String URL = "http://api.openweathermap.org/data/2.5/weather?q=Kiev,ua&appid=d46c47eac54879f975bcbe5c18c24353&units=metric";

    public static void main(String[] args) throws IOException {
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
            generateHTMLWidget(forecast);
        }
    }

    public static void generateHTMLWidget(Forecast forecast) throws IOException {
        File f = new File("index.html");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f));
        bufferedWriter.write(
                "<!DOCTYPE html>" +
                    "<html lang=\"en\">" +
                    "<head>" +
                    "    <meta charset=\"UTF-8\">" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                    "    <title>Document</title>" +
                    "</head>" +
                    "<body>" +
                    "    <h1>Прогноз погоды</h1>" +
                    "    <p>Название города: " + forecast.getName() + "</p>" +
                    "    <p>Код страны: " + forecast.getSys().getCountry() + "</p>" +
                    "    <p>Краткое описание погоды: " + forecast.getWeather()[0].getMain() + "</p>" +
                    "    <p>Полное описание погоды: " + forecast.getWeather()[0].getDescription() + "</p>" +
                    "    <p>Текущая температура в градусах Цельсия: " + forecast.getMain().getTemp() +"</p>" +
                    "    <p>Давление в мм ртутного столба: " + forecast.getMain().getPressure() + " мм. рт. ст.</p>" +
                    "    <p>Влажность в процентах: " + forecast.getMain().getHumidity() + "%</p>" +
                    "    <p>Минимальная температура за сегодня: " + forecast.getMain().getTemp_min() + "</p>" +
                    "    <p>Максимальная температура за сегодня: " + forecast.getMain().getTemp_max() + "</p>" +
                    "    <p>Скорость и направление ветра: " + forecast.getWind().getSpeed() + forecast.getWind().getDeg() + "</p>" +
                    "    <p>Облачность в процентах: " + forecast.getClouds().getAll() + "%</p>" +
                    "</body>" +
                    "</html>"
        );
        bufferedWriter.close();
    }
}

package com.alex.dag1.services;

import com.alex.dag1.models.WeatherPrediction;
import com.alex.dag1.repositories.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Service
public class ForecastService {
    @Autowired
    private ForecastRepository forecastRepository;
    //private static List<Forecast> forecasts = new ArrayList<>();

    public ForecastService(){

    }



    public List<WeatherPrediction> getForecasts(){
        return forecastRepository.findAll();
    }
    public WeatherPrediction add(WeatherPrediction weatherPrediction) {
        forecastRepository.save(weatherPrediction);
        return weatherPrediction;
    }

    public WeatherPrediction getByIndex(int i) {

        return null;
    }

    public void update(WeatherPrediction weatherPredictionFromUser) throws IOException {
        //
//        var foreCastInList = get(forecastFromUser.getId()).get();
//        foreCastInList.setTemperature(forecastFromUser.getTemperature());
//        foreCastInList.setDate(forecastFromUser.getDate());
//        foreCastInList.setHour(forecastFromUser.getHour());
//        foreCastInList.setLastModifiedBy(forecastFromUser.getLastModifiedBy());
//        writeAllToFile(forecasts);
    }

    public Optional<WeatherPrediction> get(UUID id) {
        return forecastRepository.findById(id);
//        return getForecasts().stream().filter(forecast -> forecast.getId().equals(id))
//                .findFirst();
    }

    public void getAllOnDate(LocalDate now) {
        //return forecastRepository.
    }


}


package com.alex.dag1.services;

import com.alex.dag1.models.Forecast;

import java.util.ArrayList;
import java.util.List;

public class ForecastService {
    private static List<Forecast> forecasts = new ArrayList<>();
    
    public static List<Forecast> getForecasts() {
        return forecasts;
    }

    public static void setForecasts(List<Forecast> forecasts) {
        ForecastService.forecasts = forecasts;
    }

    public void addNew(Forecast forecast) {
        forecasts.add(forecast);
    }

    public Forecast getByIndex(int i) {
        return forecasts.get(i);
    }

    public void update(Forecast forecast) {
    }
}



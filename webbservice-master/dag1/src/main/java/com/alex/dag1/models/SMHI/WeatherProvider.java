package com.alex.dag1.models.SMHI;

import com.alex.dag1.models.WeatherPrediction;

import java.util.List;


public interface WeatherProvider {
    List<WeatherPrediction> getPredictionsForRestOfDay(float longitude, float latitude);
}

package com.alex.dag1.repositories;

import com.alex.dag1.models.WeatherPrediction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ForecastRepository extends CrudRepository<WeatherPrediction, UUID> {
    @Override
    List<WeatherPrediction> findAll();
    List<WeatherPrediction> findAllByPredictionDatum(LocalDate predictionDatum);
}


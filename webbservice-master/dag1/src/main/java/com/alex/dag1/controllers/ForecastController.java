package com.alex.dag1.controllers;

import com.alex.dag1.models.WeatherPrediction;
import com.alex.dag1.services.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Client anropar /api/forecasts
// Spring kollar vilken funktion hanterar denna /api/forecasts
// Spring anropar den funktionen
// Spring tar det som funktionen returnerar och gör till JSON
// Spring skickar tillbaka JSON till client

@RestController
public class ForecastController {
    @Autowired
    private ForecastService service;

    @GetMapping("/api/products")
    public ResponseEntity<List<WeatherPrediction>> getAll() {
        return new ResponseEntity<>(service.getForecasts(), HttpStatus.OK);
    }

    @GetMapping("/api/forecasts/{id}")
    public ResponseEntity<WeatherPrediction> Get(@PathVariable UUID id) {
        Optional<WeatherPrediction> product = service.get(id);
        if (product.isPresent()) return ResponseEntity.ok(product.get());
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/api/forecasts/{id}")
    public ResponseEntity<WeatherPrediction> Update(@PathVariable UUID id, @RequestBody WeatherPrediction weatherPrediction) throws IOException {
        service.update(weatherPrediction);
        return ResponseEntity.ok(weatherPrediction);
    }

    /*@PostMapping("/api/forecasts")
    public ResponseEntity<Forecast> New (@RequestBody Forecast forecast) throws IOException { // id
        var newCreated = service.add(forecast);
        return ResponseEntity.ok(newCreated);
    }

     */
}

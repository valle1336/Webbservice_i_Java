package com.alex.dag1.models;

import com.alex.dag1.repositories.ForecastRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class PredictionService {
    @Autowired
    ForecastRepository forecastRepository;
    private static List<WeatherPrediction> allPredictions;



    public List<WeatherPrediction> Search(int dag, int fromHour, int toHour) throws ParseException {

        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = originalFormat.parse(String.valueOf(dag));

        var cDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return forecastRepository.findAll()
                .stream()
                .filter(prediction ->  prediction.getPredictionDatum().isEqual(cDate) && prediction.getPredictionHour() >= fromHour && prediction.getPredictionHour() <= toHour )
                .toList();

    }

    public WeatherPrediction createNew(WeatherPrediction weatherPrediction) {
        forecastRepository.save(weatherPrediction);

        return weatherPrediction;
    }



    public void update (WeatherPrediction weatherPrediction){
        forecastRepository.save(weatherPrediction);
    }


    private List<WeatherPrediction> readAllFromFile() throws IOException {
        if(!Files.exists(Path.of("predictions.json"))) return new ArrayList<WeatherPrediction>();
        ObjectMapper objectMapper = getObjectMapper();
        var jsonStr = Files.readString(Path.of("predictions.json"));
        return  new ArrayList(Arrays.asList(objectMapper.readValue(jsonStr, WeatherPrediction[].class ) ));
    }





    private static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }




}

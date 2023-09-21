package com.alex.dag1.models.SMHI;


import com.alex.dag1.models.DataSource;
import com.alex.dag1.models.WeatherPrediction;
import com.alex.dag1.models.PredictionService;
import com.alex.dag1.services.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@SpringBootApplication
public class CrudConsoleApplication implements CommandLineRunner {

    @Autowired
    private PredictionService service;
    SmhiProvider smhiProvider = new SmhiProvider();
    private static final float longitude = 18.02151508449004F;
    private static final float latitude = 59.30996552541549F;

    public CrudConsoleApplication(ForecastService service) {
    }


    @Override
    public void run(String... args) throws Exception {
        var scan = new Scanner(System.in);

        while(true){
            showHeaderMenu();
            System.out.print("Action:");
            int sel = Integer.parseInt(scan.nextLine()) ;
            if(sel == 1) listPredictions(scan);
            else if(sel == 2) createNewPrediction(scan);
            else if(sel == 3) updatePrediction(scan);
            //else if(sel == 4) fetchFromSmhi();
            else if(sel == 9) break;
        }
    }

    private void fetchFromSmhi() {
      System.out.println("*** Fetching from SMHI ***");
        for(WeatherPrediction weatherPrediction : smhiProvider.getPredictionsForRestOfDay(longitude,latitude)){
            service.createNew(weatherPrediction);
        }
        System.out.println("*** Done ***");
    }

    private static Random rand = new Random();
    private void createDataForToday() {
        for(int i = 0; i < 24;i++){
            var dt = LocalDateTime.now().with(LocalTime.MIDNIGHT);
            dt = dt.plusHours(i);
            WeatherPrediction forecast = new WeatherPrediction();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            String formatDateTime = dt.format(formatter);
            int datum =Integer.parseInt(formatDateTime);


            forecast.setPredictionDatum(LocalDate.from(dt));
            forecast.setPredictionHour(dt.getHour());
            forecast.setPredictionTemperature( rand.nextInt(50) -25 );
            forecast.setDataSource(DataSource.Smhi);
            service.createNew(forecast);
        }
    }

    private void updatePrediction(Scanner scan) {
        System.out.printf("Ange vilken dag, ex %s%n", new SimpleDateFormat("yyyyMMdd").format(new Date()));
        int dag = Integer.parseInt(scan.nextLine()) ;

        List<WeatherPrediction> list = null;
        try {
            list = service.Search(dag,0,23);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int num = 0;
        try {
            for(var prediction : service.Search(dag,0,23)){
                System.out.printf("%d Kl %d:00  Temp:%d  Nederbörd:%s   Från:%s %n", num+1,  prediction.getPredictionHour(), prediction.getPredictionTemperature(), prediction.isRainOrSnow() ? "Ja":"Nej", prediction.getDataSource()  );
                num++;
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Select a row number:");
        int sel = Integer.parseInt ( scan.nextLine() );;
        var t = list.get(sel-1);

        System.out.print("New temperature:");
        int temp = Integer.parseInt ( scan.nextLine() );

        System.out.print("New Rain or snow J/N:");
        boolean rainorsnow =  scan.nextLine().toLowerCase().startsWith("j") ;

        t.setPredictionTemperature(temp);
        t.setRainOrSnow(rainorsnow);

        var forecast = new WeatherPrediction();
        service.update(forecast);
    }

    private void createNewPrediction(Scanner scan) {
        System.out.println("*** CREATE PREDICTION ***");
        System.out.printf("Ange vilken dag, ex %s:", new SimpleDateFormat("yyyyMMdd").format(new Date()));
        int dag = Integer.parseInt(scan.nextLine()) ;

        System.out.print("Hour:");
        int hour = Integer.parseInt ( scan.nextLine() );

        System.out.print("Temperature:");
        int temp = Integer.parseInt ( scan.nextLine() );

        System.out.print("Rain or snow J/N:");
        boolean rainorsnow =  scan.nextLine().toLowerCase().startsWith("j") ;

        System.out.print("Provider: (S=Smhi, O=OpenWeatherMap)");
        String input = scan.nextLine();
        DataSource provider;
        if(input.equals("S")) {
            provider = DataSource.Smhi;
        } else{
            provider = DataSource.OpenWeatherMap;
        }

        WeatherPrediction weatherPrediction = new WeatherPrediction();
        weatherPrediction.setId(UUID.randomUUID());
        weatherPrediction.setPredictionDatum(LocalDate.now());
        weatherPrediction.setPredictionTemperature(temp);
        weatherPrediction.setPredictionHour(hour);
        weatherPrediction.setDataSource(provider);
        weatherPrediction.setRainOrSnow(rainorsnow);

        service.createNew(weatherPrediction);


    }

    private void listPredictions(Scanner scan) {
        System.out.printf("Ange vilken dag, ex %s%n", new SimpleDateFormat("yyyyMMdd").format(new Date()));
        int dag = Integer.parseInt(scan.nextLine()) ;
        try {
            for(var prediction : service.Search(dag,0,23)){
                System.out.printf("Kl %d:00  Temp:%d  Nederbörd:%s   Från:%s %n", prediction.getPredictionHour(), prediction.getPredictionTemperature(), prediction.isRainOrSnow() ? "Ja":"Nej", prediction.getDataSource()  );
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    private void showHeaderMenu() {
        System.out.println("1. See registrations");
        System.out.println("2. Create registration");
        System.out.println("3. Update registration");
        System.out.println("4. Fetch from SMHI");
        System.out.println("9. Exit");
    }
}
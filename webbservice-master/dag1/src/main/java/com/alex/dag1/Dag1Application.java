package com.alex.dag1;

import com.alex.dag1.models.WeatherPrediction;
import com.alex.dag1.models.SMHI.*;
import com.alex.dag1.services.ForecastService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.UUID;

@SpringBootApplication
public class Dag1Application implements CommandLineRunner {

	Scanner scan = new Scanner(System.in);


	@Autowired
	private ForecastService service;

	CrudConsoleApplication crud = new CrudConsoleApplication(service);




	public static void main(String[] args) {

		SpringApplication.run(Dag1Application.class, args);
	}



	@Override
	public void run(String... args) throws Exception {


		//Kommer hämta värderna från länken och lägga in de i våran klass / i våra variablar.



		while (true) {
			System.out.println(
					"1. List all \n" +
					"2. Create \n" +
					"3. Update \n" +
					"4. Fetch from SMHI \n" +
					"9. Exit");
			int sel = scan.nextInt();

			switch (sel) {
				case 1:
					listPredicitions(); //Skickar oss till denna metod samma med nedre alternativ
					break;
				case 2:
					addPrediction();
					break;
				case 3:
					//updatePrediction(scan);
					break;
				case 4:
					fetchFromSmhi();
				case 5:
					crud.run();
					break;
				case 9:
					exitApplication();
					break;
			}
		}
	}

	private void fetchFromSmhi() throws IOException {
		var objectMapper = new ObjectMapper();

		Root root = objectMapper.readValue(new URL("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/16.158/lat/58.5812/data.json"), Root.class);
// Varje timeserie är ett klockslag , 10:00 11:00 12:00 13:00
		for(var timeSerie : root.timeSeries){
//Väder info
			var forecast = new WeatherPrediction();
			forecast.setId(UUID.randomUUID());
			forecast.setPredictionHour(timeSerie.validTime.getHours());
			forecast.setPredictionDatum( timeSerie.validTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() );
			for(var parameter : timeSerie.getParameters()){
				if(parameter.getName().equals("t")){
					forecast.setPredictionTemperature((int) parameter.getValues().get(0).floatValue());
				}
			}
			service.add(forecast);
		}
	}

	private void exitApplication() {

		System.exit(1);

	}

	/*

	private void updatePrediction(Scanner scan) throws IOException {

		listPredicitions();
		System.out.println("Ange vilken du vill uppdatera:");
		int num = scan.nextInt();

		var forecast = service.getByIndex(num - 1);
		System.out.println(
				forecast.getPredictionDatum()
						forecast.getPredictionHour()
						forecast.getPredictionTemperature()
		);



		System.out.println("Update temp: ");
		int temp = scan.nextInt();

		forecast.setPredictionTemperature(temp);
		service.update(forecast);

		System.out.println("Temperature was updated! :)");

	}

	 */

	private void addPrediction() {

		WeatherPrediction fore = new WeatherPrediction();

		//Input på dag, hour, temp
		//Anropa servicen - Save
		System.out.println("Add a prediction containing day, hour, temp!");

		var scan = new Scanner(System.in);

		System.out.println("Add a day!");

		System.out.println("Add an hour!!");

		int hour = scan.nextInt();

		System.out.println("Add a temperature!!");

		int temp = scan.nextInt();

		var forecast = new WeatherPrediction();
		forecast.setId(UUID.randomUUID()); // Skapar ett random ID med hjälp av UUID
		forecast.setPredictionDatum(LocalDate.now());
		forecast.setPredictionHour(hour);
		forecast.setPredictionTemperature(temp);

		System.out.println("Your prediction was added!");

		service.add(forecast);

	}

	private void listPredicitions() {

		for (var prediction : service.getForecasts()) {

			System.out.printf("%d %d %f %n",
					prediction.getPredictionDatum(),
					prediction.getPredictionHour(),
					prediction.getPredictionTemperature());

		}
	}
}



		/*

	private void getOneProduct() throws IOException {
		System.out.println("Välj produkten du vill hämta! 1-100");
		int product = scan.nextInt();
		}

/*
		if (product > 100){
			System.out.println("Det finns bara produkter mellan 1-100!");
			getOneProduct();
		}

		else {
			var objectMapper = new ObjectMapper();

			DummyJson dummyOne = objectMapper.readValue(new URL("https://dummyjson.com/products/" + product), DummyJson.class);

			String json = objectMapper.writeValueAsString(dummyOne);
			System.out.println(json);
		}
	}

 */

		/*
	private void listAll() throws IOException {
		var objectMapper = new ObjectMapper();

		System.out.println("Här är produkt 1!");

		DummyJson dummy = objectMapper.readValue(new URL("https://dummyjson.com/products/1"), DummyJson.class);

		String json = objectMapper.writeValueAsString(dummy);
		System.out.println(json);
	}
}

 */






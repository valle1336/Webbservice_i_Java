package com.alex.dag1;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.alex.dag1.models.BlogPost;
import com.alex.dag1.models.Forecast;
import com.alex.dag1.services.ForecastService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.UUID;

@SpringBootApplication
public class Dag1Application implements CommandLineRunner {

	ForecastService service = new ForecastService();




	public static void main(String[] args) {
		SpringApplication.run(Dag1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var objectMapper = new ObjectMapper();

		//BlogPost []blogPosts = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts"),
		//BlogPost[].class);

		// BlogPost blogPost = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts/1"),
				// BlogPost.class); //Kommer hämta värderna från länken och lägga in de i våran klass / i våra variablar.


		var scan = new Scanner(System.in);

		var castFore = new Forecast();
		castFore.setId(UUID.randomUUID());
		castFore.setTemperature(21f);
		castFore.setDate(20230824);
		castFore.setHour(12);
		String json = objectMapper.writeValueAsString(castFore); //Skapar ett json object av "castFore" gör det till String.
		System.out.println("This is the json object: " + json);

		Forecast forecastTwo = objectMapper.readValue(json, Forecast.class); //Vet ej vad detta gör :/ typ samma sak?

		while(true){
			System.out.println("1. List all");
			System.out.println("2. Create");
			System.out.println("3. Update");
			System.out.println("9. Exit");
			int sel = scan.nextInt();

			switch(sel){
				case 1:
					listPredicitions(); //Skickar oss till denna metod samma med nedre alternativ
					break;
				case 2:
					addPrediction();
					break;
				case 3:
					updatePrediction(scan);
					break;
				case 9:
					break;
			}

		}
	}

	private void updatePrediction(Scanner scan) throws IOException {
		listPredicitions();
		System.out.println("Ange vilken du vill uppdatera:");
		int num = scan.nextInt();

		var forecast = service.getByIndex(num-1);
		System.out.println(
				forecast.getDate() +
				forecast.getHour() +
				forecast.getTemperature()
		);

		System.out.println("Update temp: ");
		float temp = scan.nextFloat();

		forecast.setTemperature(temp);
		service.update(forecast);

		System.out.println("Temperature was updated! :)");
	}

	private void addPrediction() {

		Forecast fore = new Forecast();

		//Input på dag, hour, temp
		//Anropa servicen - Save
		System.out.println("Add a prediction containing day, hour, temp!");

		var scan = new Scanner(System.in);

		System.out.println("Add a day!");

		int day = scan.nextInt();

		System.out.println("Add an hour!!");

		int hour = scan.nextInt();

		System.out.println("Add a temperature!!");

		float temp = scan.nextFloat();

		var forecast = new Forecast();
		forecast.setId(UUID.randomUUID()); // Skapar ett random ID med hjälp av UUID
		forecast.setDate(day);
		forecast.setHour(hour);
		forecast.setTemperature(temp);

		System.out.println("Your prediction was added!");

		service.addNew(forecast);
	}

	private void listPredicitions() {
		for (var prediction : service.getForecasts()) {

			System.out.printf("%d %d %f %n",
			prediction.getDate(),
			prediction.getHour(),
			prediction.getTemperature());

		}
	}
}

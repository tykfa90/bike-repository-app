package pl.sda.bikerepositoryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BikeRepositoryAppApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BikeRepositoryAppApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BikeRepositoryAppApplication.class, args);
	}
}

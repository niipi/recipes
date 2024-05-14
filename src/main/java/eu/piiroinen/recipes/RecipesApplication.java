package eu.piiroinen.recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class RecipesApplication {

	private final String LOCALHOST = "http://localhost:5173";

	public static void main(String[] args) {
		SpringApplication.run(RecipesApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/categories/all").allowedOrigins(LOCALHOST);
				registry.addMapping("/categories/recipe").allowedOrigins(LOCALHOST);
				registry.addMapping("/recipe/id").allowedOrigins(LOCALHOST);
				registry.addMapping("/recipe/categories").allowedOrigins(LOCALHOST);
				registry.addMapping("/recipe/season").allowedOrigins(LOCALHOST);
				registry.addMapping("/recipe/favourite").allowedOrigins(LOCALHOST);
			}
		};
	}
}

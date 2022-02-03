package no.ntnu.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class LibraryApplication {

	public static void main(String[] args) {
		JDBCLogic jdbcLogic = new JDBCLogic();
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/**"))
				.apis(RequestHandlerSelectors.basePackage("no.ntnu"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"AppDev Library Experiment",
				"Project for testing spring and swagger",
				"1.0",
				"https://github.com/jKm00/Application_course_exercises",
				new Contact("Joakim Edvardsen", "https://github.com/jKm00", null),
				"API Licens",
				"https://github.com/jKm00/Application_course_exercises/LICENSE",
				Collections.emptyList()
		);
	}
}

package no.ntnu.SpringDataJPA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	private void insertFourEmployees(EmployeeRepository repository) {
		repository.save(new Employee("Joakim", "Edvardsen"));
		repository.save(new Employee("Torstein", "Eide"));
		repository.save(new Employee("Richileu", "Bailey"));
		repository.save(new Employee("Eduard", "Cristea"));
	}

	@Bean
	public CommandLineRunner run(EmployeeRepository repository) {
		return (args) -> {
			insertFourEmployees(repository);
			System.out.println(repository.findAll());
		};
	}

}

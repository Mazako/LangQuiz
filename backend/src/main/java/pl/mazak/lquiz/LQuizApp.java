package pl.mazak.lquiz;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongock
@EnableMongoRepositories
public class LQuizApp {

	public static void main(String[] args) {
		SpringApplication.run(LQuizApp.class, args);
	}


}

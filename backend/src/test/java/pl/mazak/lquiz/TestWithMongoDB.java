package pl.mazak.lquiz;

import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@Testcontainers
@SpringBootTest(properties = {
        "spring.data.mongodb.database=LangQuiz"},
        webEnvironment = RANDOM_PORT,
        classes = LQuizApp.class
)
public class TestWithMongoDB {

    @Container
    public static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest")
            .withExposedPorts(27017)
            .withReuse(true);
    @BeforeAll
    public static void setup() {
        mongoDBContainer.start();
    }

    @DynamicPropertySource
    static void setProps(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", () -> mongoDBContainer.getReplicaSetUrl() + "?serverSelectionTimeoutMS=200000&connectTimeoutMS=200000");
    }
}

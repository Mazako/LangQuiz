package pl.mazak.lquiz;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;

@Configuration
@SpringBootTest(properties = {
        "spring.data.mongodb.host=localhost",
        "spring.data.mongodb.database=LangQuiz",
        "spring.data.mongodb.port=${app.db.port}"
})
@EnableMongoRepositories
public class TestWithMongoDB {

    @Container
    public static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest")
            .withExposedPorts(27717);

    @BeforeAll
    public static void setup() {
        mongoDBContainer.start();
        var port = mongoDBContainer.getMappedPort(27717);
        System.setProperty("app.db.port", port.toString());
    }
}

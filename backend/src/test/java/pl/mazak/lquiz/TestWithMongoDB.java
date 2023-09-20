package pl.mazak.lquiz;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Testcontainers
@SpringBootTest(properties = {
        "spring.data.mongodb.database=LangQuiz",
        "server.port=9999"},
        webEnvironment = DEFINED_PORT,
        classes = {LQuizApp.class, TestConfig.class}
)
@AutoConfigureWebMvc
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

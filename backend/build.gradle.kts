plugins {
	java
	id("org.springframework.boot") version "3.1.3"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "pl.mazak"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-jetty")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

	implementation("org.springframework.boot:spring-boot-starter-mail")
//	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("io.mongock:mongock-bom:5.3.4")
	compileOnly("io.mongock:mongock-springboot-v3:5.3.4")
	implementation("io.mongock:mongodb-springdata-v4-driver:5.3.4")

	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
//	implementation("org.springframework.session:spring-session-jdbc")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")

}

tasks.withType<Test> {
	useJUnitPlatform()
}

configurations {
	all {
		exclude("org.springframework.boot", "spring-boot-starter-tomcat")
	}
}

// BECAUSE SPRING WORKS ON SERVLET 6.0 AND JETTY DONT SUPPORT IT
ext["jakarta-servlet.version"] = "5.0.0"
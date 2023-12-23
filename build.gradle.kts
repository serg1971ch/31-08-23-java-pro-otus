plugins {
	java
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "ru.otus"
version = "0.0.1-SNAPSHOT"


java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation ("org.springframework.boot:spring-boot-starter")
	testImplementation ("org.springframework.boot:spring-boot-starter-test")
	implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
	implementation("org.hibernate:hibernate-core:6.3.1.Final")

	implementation("org.slf4j:slf4j-api:2.0.7")
	implementation("org.ehcache:ehcache")
	implementation("com.h2database:h2")
	implementation("org.flywaydb:flyway-core")
	implementation("com.google.code.gson:gson")
	implementation("org.postgresql:postgresql:42.6.0")
	implementation("org.eclipse.jetty:jetty-servlet:11.0.17")
    implementation("org.eclipse.jetty:jetty-webapp:11.0.15")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
	implementation("org.slf4j:slf4j-api:2.0.7")
	testImplementation("com.h2database:h2:2.2.220")
	implementation("org.neo4j.driver:neo4j-java-driver")
	implementation ("org.projectlombok:lombok:1.18.20")
	implementation("org.eclipse.jetty:jetty-server")
	implementation("org.eclipse.jetty:jetty-security")
	implementation("org.eclipse.jetty:jetty-http:")
	implementation("org.eclipse.jetty:jetty-io:")
	implementation("org.eclipse.jetty:jetty-util:")
	implementation("org.freemarker:freemarker:")
	testImplementation("org.junit.jupiter:junit-jupiter-engine")
	testImplementation("org.junit.jupiter:junit-jupiter-params")
	testImplementation("org.mockito:mockito-junit-jupiter")
	testImplementation("org.testcontainers:junit-jupiter")
}

tasks.withType<Test> {
	useJUnitPlatform()
}


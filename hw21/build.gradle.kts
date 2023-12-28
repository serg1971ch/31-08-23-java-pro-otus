plugins {
    id("java")
}

group = "org.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("org.postgresql:postgresql:42.5.1")
    implementation("org.flywaydb:flyway-core:10.1.0")
    implementation("org.hibernate:hibernate-core:6.3.1.Final")
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    implementation("org.slf4j:slf4j-api:2.0.7")
    compileOnly("org.projectlombok:lombok:1.18.26")
}

tasks.test {
    useJUnitPlatform()
}
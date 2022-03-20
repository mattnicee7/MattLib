repositories {
    mavenCentral()
}

dependencies {
    // SQLite Driver
    implementation("org.xerial:sqlite-jdbc:3.36.0.3")

    // MySQL Driver
    implementation("mysql:mysql-connector-java:8.0.28")

    // PostgreSQL Driver
    implementation("org.postgresql:postgresql:42.3.3")

    // MariaDB Driver
    implementation("org.mariadb.jdbc:mariadb-java-client:3.0.3")
}
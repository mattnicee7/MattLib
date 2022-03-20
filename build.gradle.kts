plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "com.github.mattnicee7"
version = "1.2.0"

allprojects {

    apply(plugin = "java")
    apply(plugin = "com.github.johnrengelman.shadow")

    repositories {
        mavenCentral()
    }

    dependencies {
        // Lombok
        compileOnly("org.projectlombok:lombok:1.18.22")
        annotationProcessor("org.projectlombok:lombok:1.18.22")

        // JetBrains Annotations
        implementation("org.jetbrains:annotations:23.0.0")
    }

}
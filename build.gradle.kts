plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.0"
    id("maven-publish")
}

allprojects {
    group = "com.github.mattnicee7.mattlib"
    version = "1.2.1"

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

subprojects {
    apply(plugin = "maven-publish")

    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = project.group as String?
                artifactId = project.name
                version = project.version as String?

                from(components["java"])
            }
        }
    }
}
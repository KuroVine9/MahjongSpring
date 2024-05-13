plugins {
    kotlin("jvm")
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    id("org.asciidoctor.jvm.convert") version "3.3.2"
    kotlin("plugin.spring") version "1.9.22"
}
dependencies {
    implementation("net.dv8tion:JDA:5.0.0-beta.20")
    implementation(project(":business:oauth-api"))
    implementation(project(":business:kotlin-common"))
}
repositories {
    mavenCentral()
}
kotlin {
    jvmToolchain(17)
}
import net.minecrell.pluginyml.bukkit.BukkitPluginDescription
import net.minecrell.pluginyml.paper.PaperPluginDescription

group = "net.hareworks"
version = "1.0"

plugins {
    kotlin("jvm") version "1.9.23"
    id("net.minecrell.plugin-yml.paper") version "0.6.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}
repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
}
dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.6-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}
tasks {
    shadowJar {
        archiveBaseName.set("DevUtil")
        archiveClassifier.set("")
    }
}

paper {
    main = "net.hareworks.developutil.App"
    apiVersion = "1.20.6"
    name = "DevelopersUtility"
    description = ""
    version = getVersion().toString()
    authors = listOf(
                "Hare-K02",
            )
    permissions {
        register("devu.command") {
            description = "Allows the player to use /devu command"
            default = BukkitPluginDescription.Permission.Default.OP
        }
		}
}

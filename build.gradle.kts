import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

group = "net.hareworks"
version = "1.0"

plugins {
    kotlin("jvm") version "1.9.23"
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}
repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
}
dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.6-R0.1-SNAPSHOT")
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib")
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

bukkit {
    main = "net.hareworks.developutil.App"
    name = "DevelopersUtility"
    description = ""
    version = getVersion().toString()
    apiVersion = "1.20.6"
    authors =
            listOf(
                "Hare-K02",
            )
    commands {
        register("devu") {
            description = "develop-util command"
            usage = "/devu"
            permission = "devu.command"
            permissionMessage = "You don't have permission to use this command."
        }
    }
    permissions {
        register("devu.command") {
            description = "Allows the player to use /devu command"
            default = BukkitPluginDescription.Permission.Default.OP
        }
		}
}

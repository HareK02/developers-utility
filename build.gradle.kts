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
        archiveBaseName.set("JarName")
        archiveClassifier.set("")
    }
}

bukkit {
    main = "net.hareworks.hook-n-update.App"
    name = "Hook-n-Update"
    description = "Publish Webhook to automatically update your plugin."
    version = getVersion().toString()
    apiVersion = "1.20.6"
    authors =
            listOf(
                "Hare-K02",
            )
    commands {
        register("hnu") {
            description = "hook-n-update command"
            usage = "/hnu"
            permission = "hnu.command"
            permissionMessage = "You don't have permission to use this command."
        }
    }
    permissions {
        register("hnu.command") {
            description = "Allows the player to use /hooknupdate command"
            default = BukkitPluginDescription.Permission.Default.OP
        }
		}
}

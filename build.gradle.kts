import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

group = "net.hareworks"
version = "1.0"

plugins {
    kotlin("jvm") version "1.9.22"
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}
repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}
dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}
tasks {
    shadowJar {
        archiveBaseName.set("JarName")
        archiveClassifier.set("")
    }
}

bukkit {
    main = "net.hareworks.sampleplugin.App"
    name = "SamplePaperPluginWithKotlin"
    description = "This is a sample plugin for PaperMC with Kotlin."
    version = getVersion().toString()
		apiVersion = "1.20"
    authors =
            listOf(
                "Hare-K02",
            )
    commands {
        register("test") {
            description = "test command"
            usage = "/test"
            permission = "test.command"
            permissionMessage = "permissionMessage"
        }
    }
    permissions {
        register("test.command") {
            description = "test command"
            default = BukkitPluginDescription.Permission.Default.OP
        }
		}
}

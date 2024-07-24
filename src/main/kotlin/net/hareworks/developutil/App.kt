package net.hareworks.developutil

import java.io.File
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin

public class App : JavaPlugin() {
  companion object {
    lateinit var instance: App
      private set
  }
  override fun onEnable() {
    instance = this
    initConfig()
  }

  fun initConfig() {
    val file = File(getDataFolder(), "entries.yml")
    if (!file.exists()) {
      file.getParentFile().mkdirs()
      saveResource("entries.yml", false)
    }
    val config = YamlConfiguration()
    try {
      config.load(file)
    } catch (e: Exception) {
      e.printStackTrace()
    }
    config.getMapList("entries")?.forEach { entry ->
      App.instance.getLogger().info("Loading entry: $entry")
    }

    File(getDataFolder(), "ssh").run {
      if (!exists()) {
        mkdirs()
      }
    }
    Key.initialize()
  }
}

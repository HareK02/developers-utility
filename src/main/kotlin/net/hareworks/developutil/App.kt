package net.hareworks.developutil

import java.io.File
import net.hareworks.developutil.entry.Entry
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin

public class App : JavaPlugin() {
    companion object {
        lateinit var instance: App
            private set
    }
    override fun onEnable() {
        instance = this
        saveDefaultConfig()
        initEntries()
        Key.initialize()
    }
}

fun initEntries() {
    val file = File(App.instance.getDataFolder(), "entries.yml")
    val config = YamlConfiguration.loadConfiguration(file)
    val entries = config.getConfigurationSection("entries")
    entries!!.getKeys(false).forEach { key -> Entry.addEntry(key, entries.getString(key)!!) }
}

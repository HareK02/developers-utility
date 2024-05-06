package net.hareworks.sampleplugin;

import org.bukkit.plugin.java.JavaPlugin

public class App : JavaPlugin() {
	companion object {
		lateinit var instance: App
			private set
	}
	override fun onEnable() {
        instance = this
    }
}

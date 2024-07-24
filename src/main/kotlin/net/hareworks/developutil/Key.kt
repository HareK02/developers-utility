package net.hareworks.developutil;

import java.io.BufferedReader
import java.io.InputStreamReader
import org.bukkit.Bukkit

public class Key {
  companion object {
      public fun initialize() {
        //test
        val process = Runtime.getRuntime().exec("ls")
        val inputStream = process.inputStream
        val reader = BufferedReader(InputStreamReader(inputStream))
        val output = StringBuilder()

        var line: String?
        while (reader.readLine().also { line = it } != null) {
          output.append(line)
          output.append("\n")
        }

        println(output.toString())
    }
  }
}
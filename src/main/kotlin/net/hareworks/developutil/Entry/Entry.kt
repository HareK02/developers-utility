package net.hareworks.developutil.entry;

import net.hareworks.developutil.entry.source.*;

public class Entry {
    var title: String
    var reference: String

    constructor(title: String, reference: String) {
        this.title = title
        this.reference = reference
    }

    companion object {
      var entries = mutableListOf<Entry>()

      fun addEntry(title: String, reference: String) {
        entries.add(Entry(title, reference))
      }
    }
}
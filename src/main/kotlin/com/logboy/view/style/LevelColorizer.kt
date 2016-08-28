package com.logboy.view.style

import com.intellij.util.containers.HashMap
import com.logboy.domain.Level
import com.logboy.domain.LogLine

private val levelColorMap = mapOf(

    Level.INFO to "#ffffas",
    Level.DEBUG to "#ffffas",
    Level.ERROR to "#ffffas",
    Level.FATAL to "#ffffas",
    Level.TRACE to "#ffffas"

)


class LevelColorizer {
  fun colorFor(logLine: LogLine): String? {
    return levelColorMap[logLine.level]
  }
}


inline fun <reified T> whatever(a: Any): T? = if(a is T) a else null
package logboy.view.style

import logboy.file.log.domain.log.Level
import logboy.file.log.domain.log.LogLine

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
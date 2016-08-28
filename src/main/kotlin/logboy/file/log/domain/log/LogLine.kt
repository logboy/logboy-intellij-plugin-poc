package logboy.file.log.domain.log

import java.time.LocalDateTime


enum class Level {
  TRACE,
  DEBUG,
  INFO,
  ERROR,
  FATAL
}

data class LogLine(
    val content: String,
    val timestamp: LocalDateTime?,
    val level: Level?,
    val location: CodeLocation
)

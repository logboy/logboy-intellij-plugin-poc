package logboy.file.log.parser

import logboy.file.log.domain.log.CodeLocation
import logboy.file.log.domain.log.LogLine

interface LineParser {
  fun parse(rawLine: String): LogLine?
}

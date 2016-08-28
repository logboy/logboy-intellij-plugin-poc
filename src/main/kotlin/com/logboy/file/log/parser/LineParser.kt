package com.logboy.file.log.parser

import com.logboy.file.log.domain.log.CodeLocation
import com.logboy.file.log.domain.log.LogLine

interface LineParser {
  fun parse(rawLine: String): LogLine?
}

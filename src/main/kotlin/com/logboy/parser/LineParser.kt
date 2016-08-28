package com.logboy.parser

import com.logboy.domain.PreciseCodeLineLocation
import com.logboy.domain.LogLine

interface LineParser {
  fun parse(rawLine: String): LogLine?
}

package com.logboy.parser

import com.logboy.domain.LogLine


class TryAllLineParser(val matchers: List<(String) -> LogLine?>) : LineParser {

  override fun parse(rawLine: String): LogLine? {
    var goodMatch: LogLine? = null
    for (matcher in matchers)
      goodMatch = goodMatch ?: matcher(rawLine)

    return goodMatch
  }

}


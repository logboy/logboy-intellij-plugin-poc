package logboy.file.log.parser

import logboy.file.log.domain.log.*
import logboy.util.emptyToNull
import java.time.LocalDateTime


private val simplestMatchers: List<(String) -> LogLine?> =
    listOf(
        JavaLog4JClassicLineParser()
    )

class SimplePatternLineParser(

    val matchers: List<(String) -> LogLine?>

) : LineParser {

  override fun parse(rawLine: String): LogLine? {
    var goodMatch: LogLine? = null
    for (matcher in matchers)
      goodMatch = goodMatch ?: matcher(rawLine)

    return goodMatch
  }

}




class JavaLog4JClassicLineParser : (String) -> LogLine? {
  override fun invoke(logLine: String): LogLine? {
    val groups = Regex("(\\d{4}-\\d{2}-\\d{2}) (\\d{2}:\\d{2}:\\d{2},\\d{3}) +\\[(.*)\\] +([^ ]*) +([^ :]*)(:([0-9]+))? +- (.*)$")
        .matchEntire(logLine)?.groupValues

    return groups?.let {
      val time = groups[2]
      val splittedTime = time.split(",")
      val withoutMiliTime = splittedTime[0]

      val date = groups[1]

      val dateTime = LocalDateTime.parse("${date}T${withoutMiliTime}")

      val content = groups[8]

      val level = Level.valueOf(groups[4].toUpperCase())

      val preciseCodeLocation = groups.getOrNull(7).emptyToNull()?.toInt()?.let { PreciseLineLocation(it) }
      val codeLocation = CodeLocation(null, CodeClass.fromFullyQualified(groups[5]), preciseCodeLocation)

      LogLine(content, dateTime, level, codeLocation)
    }
  }
}

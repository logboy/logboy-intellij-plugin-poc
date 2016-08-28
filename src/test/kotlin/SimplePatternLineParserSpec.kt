import io.kotlintest.specs.StringSpec
import com.logboy.file.log.domain.log.CodeClass
import com.logboy.file.log.domain.log.CodeLocation
import com.logboy.file.log.domain.log.Level
import com.logboy.file.log.domain.log.PreciseLineLocation
import com.logboy.file.log.parser.JavaLog4JClassicLineParser
import java.time.LocalDateTime
import kotlin.test.assertEquals
import kotlin.test.assertNotNull


class SimplePatternLineParserSpec : StringSpec() {
  init {
    "java log line pattern parser should correctly parse log strings" {
      val javaParser = JavaLog4JClassicLineParser()

      val testTable = table(

          headers("logLine", "expectedLevel", "expectedDate", "expectedContent", "expectedCodeLocation"),


          row("2014-07-02 20:52:39,134 [main] DEBUG ClassName - This is debug message2",
              Level.DEBUG,
              LocalDateTime.of(2014, 7, 2, 20, 52, 39),
              "This is debug message2",
              CodeLocation(null, CodeClass("ClassName"), null)),


          row("2014-07-02 20:52:45,134 [main thread whatever]  ERROR   com.withPackage.ClassName:154 - This is debug message2       some spaces",
              Level.ERROR,
              LocalDateTime.of(2014, 7, 2, 20, 52, 45),
              "This is debug message2       some spaces",
              CodeLocation(null, CodeClass("ClassName", "com.withPackage"), PreciseLineLocation(line = 154))
          )


      )

      forAll(testTable) { logLine, expectedLevel, expectedDate, expectedContent, expectedCodeLocation ->


        // when
        val probablyParsed = javaParser(logLine)

        // then
        assertNotNull(probablyParsed)

        val parsed = probablyParsed!!

        assertNotNull(parsed.level)

        assertEquals(expectedLevel, parsed.level)

        assertEquals(expectedDate, parsed.timestamp)

        assertEquals(expectedContent, parsed.content)

        assertEquals(expectedCodeLocation, parsed.location)


      }


    }
  }
}


package logboy.view

import logboy.file.log.domain.log.LogLine
import logboy.psi.IntellijLocalProjectContext

interface ViewLogConsumer {
  fun consume(context: IntellijLocalProjectContext, logLine: LogLine)
}
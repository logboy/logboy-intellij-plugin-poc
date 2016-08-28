package com.logboy.view

import com.logboy.file.log.domain.log.LogLine
import com.logboy.psi.IntellijLocalProjectContext

interface ViewLogConsumer {
  fun consume(context: IntellijLocalProjectContext, logLine: LogLine)
}
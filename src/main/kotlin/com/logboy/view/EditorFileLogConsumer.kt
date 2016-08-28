package com.logboy.view

import com.logboy.domain.LogLine
import com.logboy.psi.IntellijLocalProjectContext
import com.logboy.psi.SimpleLineLogLocator

class EditorFileLogConsumer(logLocator: SimpleLineLogLocator): ViewLogConsumer {
  override fun consume(context: IntellijLocalProjectContext, logLine: LogLine) {

  }

}
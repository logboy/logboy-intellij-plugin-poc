package com.logboy.view

import com.logboy.file.log.domain.log.LogLine
import com.logboy.psi.IntellijLocalProjectContext

class EditorLineLogConsumer: ViewLogConsumer {
  override fun consume(context: IntellijLocalProjectContext, logLine: LogLine) {
    throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

}


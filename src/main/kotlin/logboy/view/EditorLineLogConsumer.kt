package logboy.view

import logboy.file.log.domain.log.LogLine
import logboy.psi.IntellijLocalProjectContext

class EditorLineLogConsumer: ViewLogConsumer {
  override fun consume(context: IntellijLocalProjectContext, logLine: LogLine) {
    throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

}


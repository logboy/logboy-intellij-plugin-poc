package com.logboy.psi

import com.logboy.file.log.domain.log.CodeLocation


class SimpleLineLogLocator: PsiLineLogLocator {
  override fun locate(localProjectContext: IntellijLocalProjectContext,
                      logOriginContext: LogOriginContext,
                      codeLocation: CodeLocation): PsiLocSpec {
    throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

}


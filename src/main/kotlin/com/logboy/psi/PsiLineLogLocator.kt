package com.logboy.psi

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.logboy.file.log.domain.log.CodeLocation

data class PsiLocSpec(val psiElement: PsiElement, val file: String?, val offset: Int?)

data class IntellijLocalProjectContext(
    val vcsHash: String,
    val editor: Editor,
    val project: Project
)

data class LogOriginContext(
    val vcsHash: String
)


interface PsiLineLogLocator {
  fun locate(
      localProjectContext: IntellijLocalProjectContext,
      logOriginContext: LogOriginContext,

      codeLocation: CodeLocation
  ): PsiLocSpec
}
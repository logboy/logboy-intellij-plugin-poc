package com.logboy.psi

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.logboy.domain.PreciseCodeLineLocation

data class PsiLocation(val psiFile: PsiFile, val psiOffset: Int? = null)

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

      codeLocation: PreciseCodeLineLocation
  ): PsiLocation?
}
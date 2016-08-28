package com.logboy.psi

import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiFile
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope
import com.logboy.domain.PreciseCodeLineLocation
import com.myhau.unwrap.unwrap

/**
 * Java support only for now
 */
class SimpleLineLogLocator: PsiLineLogLocator {
  override fun locate(localProjectContext: IntellijLocalProjectContext,
                      logOriginContext: LogOriginContext,
                      codeLocation: PreciseCodeLineLocation): PsiLocation? {

    val allFileCandidates = mutableSetOf<PsiFile>()

    val fileCandidates = unwrap(localProjectContext.project, codeLocation.file) { project, file ->
      FilenameIndex.getFilesByName(project, file.path.toAbsolutePath().toString(), GlobalSearchScope.allScope(project))
    } ?: emptyArray()

    allFileCandidates.addAll(fileCandidates)


    val classFileCandidates = unwrap(localProjectContext.project, codeLocation.clazz) { project, clazz ->
      val psiFacade = JavaPsiFacade.getInstance(project)
      val foundClasses = psiFacade.findClasses(clazz.qualified, GlobalSearchScope.allScope(project))

      foundClasses.map { it.containingFile }
    } ?: emptyList()

    allFileCandidates.addAll(classFileCandidates)


    codeLocation.line?.let { lineSpec ->
      allFileCandidates.removeAll({ psiFile ->
        // todo: refactor, I bet it can be done better with Intellij openapi
        val linesInFile = psiFile.text.split("\n").count()
        linesInFile < lineSpec.line
      })
    }

    return allFileCandidates.singleOrNull()?.let {
      PsiLocation(it, codeLocation.line?.line)
    }

  }


}


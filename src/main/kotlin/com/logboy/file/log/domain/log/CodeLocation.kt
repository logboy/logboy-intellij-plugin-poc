package com.logboy.file.log.domain.log

import com.google.common.base.Preconditions.checkArgument
import com.google.common.base.Splitter
import java.nio.file.Path
import java.nio.file.Paths


data class CodeFile(val path: Path) {
  companion object {
    fun from(stringPath: String) = CodeFile(Paths.get(stringPath))
  }
}

data class CodeClass(val className: String, val packageString: String? = null) {

  companion object {
    fun fromFullyQualified(fullyQualifiedName: String): CodeClass {
      val packageAndClass = Splitter.on(".").limit(2).split(fullyQualifiedName.reversed()).toList().map { it.reversed() }

      checkArgument(packageAndClass.size > 0, "You should provide name like com.asd.ClassName or ClassName")

      return if (packageAndClass.size == 1) CodeClass(className = packageAndClass[0], packageString = null)
      else CodeClass(className = packageAndClass[0], packageString = packageAndClass[1])
    }
  }

}

data class PreciseLineLocation(val line: Int, val col: Int? = null)


data class CodeLocation(
    val file: CodeFile?,
    val clazz: CodeClass?,
    val line: PreciseLineLocation?
)
package com.logboy.domain

import com.google.common.base.Preconditions.checkArgument
import com.google.common.base.Splitter
import java.nio.file.Path
import java.nio.file.Paths


data class FileLocation(val path: Path) {
  companion object {
    fun from(stringPath: String) = FileLocation(Paths.get(stringPath))
  }
}

data class ClassLocation(val className: String, val packageString: String? = null) {

  companion object {
    fun fromFullyQualified(fullyQualifiedName: String): ClassLocation {
      val packageAndClass = Splitter.on(".").limit(2).split(fullyQualifiedName.reversed()).toList().map { it.reversed() }

      checkArgument(packageAndClass.size > 0, "You should provide name like com.asd.ClassName or ClassName")

      return if (packageAndClass.size == 1) ClassLocation(className = packageAndClass[0], packageString = null)
      else ClassLocation(className = packageAndClass[0], packageString = packageAndClass[1])
    }
  }

  val qualified: String
      get() = packageString?.plus(".") + className

}

data class CodeLineLocation(val line: Int, val col: Int? = null)


data class PreciseCodeLineLocation(
    val file: FileLocation?,
    val clazz: ClassLocation?,
    val line: CodeLineLocation?
)
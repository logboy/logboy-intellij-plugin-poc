package com.logboy.file.log.domain.log


sealed class ComplexContent {
  class Simple(val string: String) : ComplexContent()
  class Tree(val tree: String) : ComplexContent()
}

data class ComplexLogLineContent(val content: List<ComplexContent>) {
  val complex: List<ComplexContent>
    get() = content.filter { content -> content !is ComplexContent.Simple }

  val simple: List<ComplexContent>
    get() = content.filter { content -> content is ComplexContent.Simple }

  val simpleString: String
    get() = simple.joinToString(" ")
}


data class ComplexLogLine(val logLine: LogLine, val complexContent: ComplexLogLineContent)


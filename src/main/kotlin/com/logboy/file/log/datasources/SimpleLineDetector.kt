package com.logboy.file.log.datasources

class SimpleLineDetector: LineDetector {
  override fun detect(rawData: ByteArray): List<String> {
    val stringData = rawData.toString(Charsets.UTF_8)
    return stringData.split("\n")
  }

}
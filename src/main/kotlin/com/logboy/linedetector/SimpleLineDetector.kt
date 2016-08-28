package com.logboy.linedetector

import com.logboy.linedetector.LineDetector

class SimpleLineDetector: LineDetector {
  override fun detect(rawData: ByteArray): List<String> {
    val stringData = rawData.toString(Charsets.UTF_8)
    return stringData.split("\n")
  }

}
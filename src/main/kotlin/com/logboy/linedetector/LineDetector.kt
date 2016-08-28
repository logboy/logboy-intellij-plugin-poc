package com.logboy.linedetector

interface LineDetector {
  fun detect(rawData: ByteArray): List<String>
}
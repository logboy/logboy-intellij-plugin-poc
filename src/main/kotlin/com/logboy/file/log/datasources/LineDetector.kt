package com.logboy.file.log.datasources

interface LineDetector {
  fun detect(rawData: ByteArray): List<String>
}
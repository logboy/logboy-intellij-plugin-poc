package com.logboy.datasource.local

import com.logboy.datasource.StaticDataSource
import com.logboy.domain.LogInquiry
import java.nio.file.Files
import java.nio.file.Files.readAllBytes
import java.nio.file.Files.readAllLines
import java.nio.file.Paths

class LocalFileDataSource: StaticDataSource {
  override fun load(logInquiry: LogInquiry): ByteArray {
    val path = logInquiry.path ?: throw IllegalArgumentException()
    return readAllBytes(Paths.get(path))
  }
}
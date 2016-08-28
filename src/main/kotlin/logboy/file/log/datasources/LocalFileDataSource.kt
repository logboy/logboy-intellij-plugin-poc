package logboy.file.log.datasources

import logboy.file.log.domain.log.LogInquiry
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
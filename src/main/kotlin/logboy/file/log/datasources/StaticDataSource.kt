package logboy.file.log.datasources

import logboy.file.log.domain.log.LogInquiry


interface StaticDataSource {
  fun load(logInquiry: LogInquiry): ByteArray
}

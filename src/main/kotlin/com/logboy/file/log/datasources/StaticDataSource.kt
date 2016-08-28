package com.logboy.file.log.datasources

import com.logboy.file.log.domain.log.LogInquiry


interface StaticDataSource {
  fun load(logInquiry: LogInquiry): ByteArray
}

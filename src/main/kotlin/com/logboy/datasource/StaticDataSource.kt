package com.logboy.datasource

import com.logboy.domain.LogInquiry


interface StaticDataSource {
  fun load(logInquiry: LogInquiry): ByteArray
}

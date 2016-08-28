package logboy.file.log.domain.log

import java.time.LocalDateTime

data class LogInquiry(val gitCommitHash: String?,
                      val nearTo: LocalDateTime?,
                      val path: String?)
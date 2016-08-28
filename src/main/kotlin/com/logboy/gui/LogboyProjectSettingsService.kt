package com.logboy.gui

import com.logboy.util.emptyToNull

object LogboyProjectSettingsService {
  var logLocation: String? = null
    set(value) {
      field = validatedLogLocation(value)
    }
    get() {
      return field
    }


  private fun validatedLogLocation(location: String?): String {
    location?.emptyToNull() ?: throw IllegalStateException()
    return location!!
  }
}
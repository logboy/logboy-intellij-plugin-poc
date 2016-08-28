package logboy.util


fun String?.emptyToNull(): String? {
  return when (this) {
    null -> null
    "" -> null
    else -> this
  }
}


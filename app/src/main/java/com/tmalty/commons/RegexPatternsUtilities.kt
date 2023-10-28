package com.tmalty.commons

object RegexPatternsUtilities {
    val phoneNumberStartWithoutZeroPattern = """^[1-9][0-9]*$""".toRegex()
    var emailPattern = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$".toRegex()

}
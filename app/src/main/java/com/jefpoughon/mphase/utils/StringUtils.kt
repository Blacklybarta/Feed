package com.jefpoughon.mphase.utils

import com.jefpoughon.mphase.common.PATTERN_ISO8601_DATE
import java.text.SimpleDateFormat
import java.util.*

object StringUtils {

    /**
     * parse an ISO-8601 complaint String in a timestamp
     */
    fun fromIso8601DateStringToTimestamp(iso8601: String): Long? {
        val iso8601String = SimpleDateFormat(PATTERN_ISO8601_DATE, Locale.getDefault())
        return iso8601String.parse(iso8601)?.time
    }
}

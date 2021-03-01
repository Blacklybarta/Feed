package com.jefpoughon.mphase.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    /**
     * parse timestamp to get a date formatted in string
     */
    fun formatDateByDeviceFormat(timeStamp: Long = 0, pattern: String): String {
        val wellFormatDate = SimpleDateFormat(pattern, Locale.getDefault())
        return wellFormatDate.format(timeStamp).toString()
    }
}

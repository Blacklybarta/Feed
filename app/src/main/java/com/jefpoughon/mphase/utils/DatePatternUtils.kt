package com.jefpoughon.mphase.utils

import com.jefpoughon.mphase.common.PATTERN_HOUR_MINUTE_12
import com.jefpoughon.mphase.common.PATTERN_HOUR_MINUTE_24
import com.jefpoughon.mphase.common.PATTERN_MONTH_DAY_YEAR

object DatePatternUtils {

    /**
     * build date pattern
     * depends on device time format settings (12/24h)
     */
    fun buildDeviceFormatPattern(isH24Format: Boolean): String {
        return buildString {
            append(PATTERN_MONTH_DAY_YEAR)
            if (isH24Format)
                append(PATTERN_HOUR_MINUTE_24)
            else
                append(PATTERN_HOUR_MINUTE_12)
        }
    }
}

package com.jefpoughon.mphase.utils

import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DateUtilsTest {

    private val iso8601StringDate = "2020-08-02T03:24:00.000Z"

    @Test
    fun formatDateByDeviceFormatIn12() {
        assertEquals(
            "August 02 2020 - 5:24 AM",
            DateUtils.formatDateByDeviceFormat(
                StringUtils.fromIso8601DateStringToTimestamp(iso8601StringDate) ?: 0,
                DatePatternUtils.buildDeviceFormatPattern(false)
            )
        )
    }

    @Test
    fun formatDateByDeviceFormatIn24() {
        assertEquals(
            "August 02 2020 - 05:24",
            DateUtils.formatDateByDeviceFormat(
                StringUtils.fromIso8601DateStringToTimestamp(iso8601StringDate) ?: 0,
                DatePatternUtils.buildDeviceFormatPattern(true)
            )
        )
    }

    @After
    fun tearDown(){
        stopKoin()
    }
}

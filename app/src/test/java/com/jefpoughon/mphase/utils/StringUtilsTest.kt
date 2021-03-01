package com.jefpoughon.mphase.utils

import org.junit.Test

import java.text.ParseException

class StringUtilsTest {

    private val iso8601StringDate = "2020-08-02T03:24:00.000Z"
    private val wrongIso8601StringDate = "2020-08-02T03:"

    @Test
    fun fromIso8601DateStringToTimestamp() {
        assert(StringUtils.fromIso8601DateStringToTimestamp(iso8601StringDate) ?: 0 != 0L)
    }

    @Test(expected = ParseException::class)
    fun fromIso8601DateStringTo0() {
        StringUtils.fromIso8601DateStringToTimestamp(wrongIso8601StringDate)
    }
}
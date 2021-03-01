package com.jefpoughon.mphase.utils

import org.junit.Test

import org.junit.Assert.*

class DatePatternUtilsTest {

    private val pattern24h = "MMMM dd yyyy - HH:mm"
    private val pattern12h = "MMMM dd yyyy - h:mm a"

    @Test
    fun buildDeviceFormatPattern12h() {
        assertEquals(pattern12h, DatePatternUtils.buildDeviceFormatPattern(false))
    }

    @Test
    fun buildDeviceFormatPattern24h() {
        assertEquals(pattern24h, DatePatternUtils.buildDeviceFormatPattern(true))
    }

    @Test
    fun buildDeviceFormatPattern12to24() {
        assertNotEquals(pattern12h, DatePatternUtils.buildDeviceFormatPattern(true))
    }

    @Test
    fun buildDeviceFormatPattern24to12() {
        assertNotEquals(pattern24h, DatePatternUtils.buildDeviceFormatPattern(false))
    }
}
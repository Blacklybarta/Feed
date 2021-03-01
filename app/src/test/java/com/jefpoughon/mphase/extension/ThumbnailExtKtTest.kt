package com.jefpoughon.mphase.extension

import com.jefpoughon.mphase.common.HEROKUAPP_BASE_URL
import com.jefpoughon.mphase.model.Thumbnail
import org.junit.Assert.*
import org.junit.Test

class ThumbnailExtKtTest {

    private val testUrl = "testUrl"

    @Test
    fun toCompleteUrlTest() {
        val thumbnail = Thumbnail(url = testUrl)
        val fullUrl = thumbnail.toCompleteUrl()
        assertEquals("$HEROKUAPP_BASE_URL$testUrl", fullUrl)
    }

    @Test
    fun toErrorCompleteUrlTest() {
        val thumbnail = Thumbnail(url = testUrl)
        val fullUrl = thumbnail.toCompleteUrl()
        assertNotEquals(testUrl, fullUrl)
    }

}
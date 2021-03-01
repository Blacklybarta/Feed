package com.jefpoughon.mphase.extension

import com.jefpoughon.mphase.common.HEROKUAPP_BASE_URL
import com.jefpoughon.mphase.model.Thumbnail

/**
 * add base url to build the image's full URL
 */
fun Thumbnail.toCompleteUrl(): String {
    return buildString {
        append(HEROKUAPP_BASE_URL)
        append(url)
    }
}
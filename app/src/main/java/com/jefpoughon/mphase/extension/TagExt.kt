package com.jefpoughon.mphase.extension

import android.content.Context
import com.google.android.material.chip.Chip
import com.jefpoughon.mphase.model.Tag
import com.jefpoughon.mphase.utils.ChipUtils

/**
 * build a displayable Chip from a Tag
 */
fun Tag.toChip(context: Context): Chip {
    return Chip(context).apply {
        text = name
        ChipUtils.setChipColorFromSlug(slug, this)
        isClickable = false
    }
}
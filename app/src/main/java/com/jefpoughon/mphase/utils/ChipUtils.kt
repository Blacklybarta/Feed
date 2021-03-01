package com.jefpoughon.mphase.utils

import android.content.Context
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.jefpoughon.mphase.R
import com.jefpoughon.mphase.common.*
import org.koin.core.KoinComponent
import org.koin.core.inject

object ChipUtils : KoinComponent {

    private val context: Context by inject()

    /**
     * set color to a chip from the Tag in terms of slug value
     */
    fun setChipColorFromSlug(slug: String, chip: Chip) {
        when (slug) {
            ARTS -> {
                chip.setChipBackgroundColorResource(R.color.arts)
                chip.setTextColor(ContextCompat.getColor(context, R.color.white))
            }
            BUSINESS -> {
                chip.setChipBackgroundColorResource(R.color.business)
                chip.setTextColor(ContextCompat.getColor(context, R.color.white))
            }
            HEALTH -> {
                chip.setChipBackgroundColorResource(R.color.health)
                chip.setTextColor(ContextCompat.getColor(context, R.color.white))
            }
            LOCAL -> {
                chip.setChipBackgroundColorResource(R.color.local)
            }
            NEWS -> {
                chip.setChipBackgroundColorResource(R.color.news)
            }
            SPORTS -> {
                chip.setChipBackgroundColorResource(R.color.sports)
                chip.setTextColor(ContextCompat.getColor(context, R.color.white))
            }
            WORLD -> {
                chip.setChipBackgroundColorResource(R.color.world)
                chip.setTextColor(ContextCompat.getColor(context, R.color.white))
            }
            else -> {
                chip.setChipBackgroundColorResource(R.color.white)
            }
        }
    }
}

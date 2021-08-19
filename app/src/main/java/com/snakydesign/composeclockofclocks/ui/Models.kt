package com.snakydesign.composeclockofclocks.ui

import androidx.compose.runtime.Stable

@Stable
data class LittleClockTime(
    val firstHour: Int,
    val secondHour: Int
){
    companion object {
        val TopRight = LittleClockTime(9, 6)
        val TopLeft = LittleClockTime(3, 6)
        val BottomRight = LittleClockTime(9, 0)
        val BottomLeft = LittleClockTime(3, 0)
        val Vertical = LittleClockTime(0, 6)
        val Horizontal = LittleClockTime(3, 9)
        val Nothing = LittleClockTime(7,7)
    }
}
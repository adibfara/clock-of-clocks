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
        val Empty = LittleClockTime(7,7)

        val FiveBottomLeft = LittleClockTime(0,2)
        val FiveBottomRight = LittleClockTime(10,0)
        val FiveTopLeft = LittleClockTime(6,2)
        val FiveTopRight = LittleClockTime(10,6)
    }
}

enum class ClockSpeed(val duration: Int){
    Slow(3000),
    Fast(700)
}
typealias T = LittleClockTime
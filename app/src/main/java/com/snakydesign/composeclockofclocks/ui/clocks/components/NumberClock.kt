package com.snakydesign.composeclockofclocks.ui.clocks.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.snakydesign.composeclockofclocks.ui.ClockSpeed
import com.snakydesign.composeclockofclocks.ui.LittleClockTime
import com.snakydesign.composeclockofclocks.ui.clocks.numbers.Eight
import com.snakydesign.composeclockofclocks.ui.clocks.numbers.Five
import com.snakydesign.composeclockofclocks.ui.clocks.numbers.Four
import com.snakydesign.composeclockofclocks.ui.clocks.numbers.Nine
import com.snakydesign.composeclockofclocks.ui.clocks.numbers.One
import com.snakydesign.composeclockofclocks.ui.clocks.numbers.Seven
import com.snakydesign.composeclockofclocks.ui.clocks.numbers.Six
import com.snakydesign.composeclockofclocks.ui.clocks.numbers.Three
import com.snakydesign.composeclockofclocks.ui.clocks.numbers.Two
import com.snakydesign.composeclockofclocks.ui.clocks.numbers.Zero

@Composable
fun NumberClock(times: Array<LittleClockTime>, speed: ClockSpeed, modifier: Modifier = Modifier) {
    val rowCount = 6
    val columnHeight = 6
    if (times.size != 6 * rowCount) return
    BoxWithConstraints(modifier) {
        val clockSize = this.maxWidth / rowCount
        Column(verticalArrangement = Arrangement.SpaceEvenly) {
            (0 until columnHeight).forEach { row ->
                Row(
                    Modifier) {
                    (0 until rowCount).forEach { column ->

                        val item = times[(row * rowCount) + column]
                        SmallClock(
                            hourHandle = item.firstHour,
                            minuteHandle = item.secondHour,
                            speed = speed,
                            Modifier
                                .size(clockSize),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NumberClock(number: Int, speed: ClockSpeed, modifier: Modifier = Modifier) {
    val array = when (number) {
        1 -> One
        2 -> Two
        3 -> Three
        4 -> Four
        5 -> Five
        6 -> Six
        7 -> Seven
        8 -> Eight
        9 -> Nine
        else -> Zero
    }

    NumberClock(array, speed, modifier)
}

@Preview
@Composable
private fun NumberClockPreview() {
    NumberClock(1, ClockSpeed.Slow )
}
package com.snakydesign.composeclockofclocks.ui.clocks

import com.snakydesign.composeclockofclocks.ui.LittleClockTime
import com.snakydesign.composeclockofclocks.ui.LittleClockTime.Companion.BottomLeft
import com.snakydesign.composeclockofclocks.ui.LittleClockTime.Companion.BottomRight
import com.snakydesign.composeclockofclocks.ui.LittleClockTime.Companion.Horizontal
import com.snakydesign.composeclockofclocks.ui.LittleClockTime.Companion.TopLeft
import com.snakydesign.composeclockofclocks.ui.LittleClockTime.Companion.TopRight
import com.snakydesign.composeclockofclocks.ui.LittleClockTime.Companion.Vertical

val One = arrayOf(
    TopLeft, Horizontal, TopRight, LittleClockTime.Nothing,
    BottomLeft, TopRight, Vertical, LittleClockTime.Nothing,
    LittleClockTime.Nothing, Vertical, Vertical, LittleClockTime.Nothing,
    TopLeft, BottomRight, BottomLeft, TopRight,
    BottomLeft, Horizontal, Horizontal, BottomRight
)
val Two = arrayOf(
    TopLeft, Horizontal, Horizontal, TopRight,
    BottomLeft, Horizontal, TopRight, Vertical,
    TopLeft, Horizontal, BottomRight, Vertical,
    Vertical, TopLeft, Horizontal, BottomRight,
    Vertical, BottomLeft, Horizontal, TopRight,
    BottomLeft, Horizontal, Horizontal, BottomRight
)
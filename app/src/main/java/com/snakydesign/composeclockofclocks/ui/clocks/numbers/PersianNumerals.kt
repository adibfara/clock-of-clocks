package com.snakydesign.composeclockofclocks.ui.clocks.numbers

import com.snakydesign.composeclockofclocks.ui.LittleClockTime.Companion.BottomLeft
import com.snakydesign.composeclockofclocks.ui.LittleClockTime.Companion.BottomRight
import com.snakydesign.composeclockofclocks.ui.LittleClockTime.Companion.Empty
import com.snakydesign.composeclockofclocks.ui.LittleClockTime.Companion.Horizontal
import com.snakydesign.composeclockofclocks.ui.LittleClockTime.Companion.TopLeft
import com.snakydesign.composeclockofclocks.ui.LittleClockTime.Companion.TopRight
import com.snakydesign.composeclockofclocks.ui.LittleClockTime.Companion.Vertical
import com.snakydesign.composeclockofclocks.ui.T

val One = arrayOf(
    Empty, Empty, TopLeft, TopRight, Empty, Empty,
    Empty, Empty, Vertical, Vertical, Empty, Empty,
    Empty, Empty, Vertical, Vertical, Empty, Empty,
    Empty, Empty, Vertical, Vertical, Empty, Empty,
    Empty, Empty, Vertical, Vertical, Empty, Empty,
    Empty, Empty, BottomLeft, BottomRight, Empty, Empty,

    )
val Two = arrayOf(
    Empty, TopLeft, TopRight, TopLeft, TopRight, Empty,
    Empty, Vertical, BottomLeft, BottomRight, Vertical, Empty,
    Empty, Vertical, TopLeft, Horizontal, BottomRight, Empty,
    Empty, Vertical, Vertical, Empty, Empty, Empty,
    Empty, Vertical, Vertical, Empty, Empty, Empty,
    Empty, BottomLeft, BottomRight, Empty, Empty, Empty,

    )
val Three = arrayOf(
    TopLeft, TopRight, TopLeft, TopRight, TopLeft, TopRight,
    Vertical, BottomLeft, BottomRight, BottomLeft, BottomRight, Vertical,
    Vertical, TopLeft, Horizontal, Horizontal, Horizontal, BottomRight,
    Vertical, Vertical, Empty, Empty, Empty, Empty,
    Vertical, Vertical, Empty, Empty, Empty, Empty,
    BottomLeft, BottomRight, Empty, Empty, Empty, Empty,

    )

val Four = arrayOf(
    Empty, Empty, Empty, TopLeft, Horizontal, TopRight,
    Empty, Empty, Empty, Vertical, TopLeft, BottomRight,
    Empty, TopLeft, Horizontal, BottomRight, BottomLeft, TopRight,
    Empty, Vertical, TopLeft, Horizontal, Horizontal, BottomRight,
    Empty, Vertical, Vertical, Empty, Empty, Empty,
    Empty, BottomLeft, BottomRight, Empty, Empty, Empty,
)

val Five = arrayOf(
    TopLeft, Horizontal, Horizontal, Horizontal, Horizontal, TopRight,
    Vertical, TopLeft, Horizontal, Horizontal, TopRight, Vertical,
    Vertical, Vertical, Empty, Empty, Vertical, Vertical,
    Vertical, Vertical, TopLeft, TopRight, Vertical, Vertical,
    Vertical, BottomLeft, BottomRight, BottomLeft, BottomRight, Vertical,
    BottomLeft, Horizontal, Horizontal, Horizontal, Horizontal, BottomRight,
)

val Six = arrayOf(
    Empty, TopLeft, TopRight, TopLeft, TopRight, Empty,
    Empty, Vertical, BottomLeft, T(9, 12), Vertical, Empty,
    Empty, BottomLeft, Horizontal, TopRight, Vertical, Empty,
    Empty, Empty, Empty, Vertical, Vertical, Empty,
    Empty, Empty,Empty, Vertical, Vertical, Empty,
    Empty, Empty, Empty, BottomLeft, BottomRight, Empty,
    )

val Seven = arrayOf(
    Empty, TopLeft, TopRight, TopLeft, TopRight, Empty,
    Empty, Vertical, Vertical, Vertical, Vertical, Empty,
    Empty, Vertical, Vertical, Vertical, Vertical, Empty,
    Empty, Vertical, Vertical, Vertical, Vertical, Empty,
    Empty, Vertical, BottomLeft, BottomRight, Vertical, Empty,
    Empty, BottomLeft, Horizontal, Horizontal, BottomRight, Empty,
    )

val Eight = arrayOf(
    Empty, TopLeft, Horizontal, Horizontal, TopRight, Empty,
    Empty, Vertical, TopLeft, TopRight, Vertical, Empty,
    Empty, Vertical, Vertical, Vertical, Vertical, Empty,
    Empty, Vertical, Vertical, Vertical, Vertical, Empty,
    Empty, Vertical, Vertical, Vertical, Vertical, Empty,
    Empty, BottomLeft, BottomRight, BottomLeft, BottomRight, Empty,
    )


val Nine = arrayOf(
    Empty, TopLeft, Horizontal, Horizontal, TopRight, Empty,
    Empty, Vertical, TopLeft, TopRight, Vertical, Empty,
    Empty, Vertical, BottomLeft, BottomRight, Vertical, Empty,
    Empty, BottomLeft, Horizontal, TopRight, Vertical, Empty,
    Empty, Empty, Empty, Vertical, Vertical, Empty,
    Empty, Empty, Empty, BottomLeft, BottomRight, Empty,
    )


val Zero = arrayOf(
    Empty, Empty, Empty, Empty, Empty, Empty,
    Empty, TopLeft, Horizontal, Horizontal, TopRight, Empty,
    Empty, Vertical, TopLeft, TopRight, Vertical, Empty,
    Empty, Vertical, BottomLeft, BottomRight, Vertical, Empty,
    Empty, BottomLeft, Horizontal, Horizontal, BottomRight, Empty,
    Empty, Empty, Empty, Empty, Empty, Empty,
    )

val Separator = arrayOf(
    Empty, Empty, Empty, Empty, Empty, Empty,
    Empty, Empty, TopLeft, TopRight, Empty, Empty,
    Empty, Empty, BottomLeft, BottomRight, Empty, Empty,
    Empty, Empty, TopLeft, TopRight, Empty, Empty,
    Empty, Empty, BottomLeft, BottomRight, Empty, Empty,
    Empty, Empty, Empty, Empty, Empty, Empty,
    )

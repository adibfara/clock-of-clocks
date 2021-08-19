package com.snakydesign.composeclockofclocks.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun Dp.toPx(): Float {
    return with(LocalDensity.current) {
        toPx()
    }
}

fun Int.firstNumber(): Int {
    return this / 10
}

fun Int.secondNumber(): Int {
    return this % 10
}
package com.snakydesign.composeclockofclocks.ui.clocks.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.withSave
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.snakydesign.composeclockofclocks.ui.ClockSpeed
import com.snakydesign.composeclockofclocks.ui.toPx

@Composable
fun SmallClock(
    hourHandle: Int,
    minuteHandle: Int,
    speed: ClockSpeed,
    modifier: Modifier = Modifier,
) {
    val borderSize = 2.dp.toPx()
    val borderColor = Color(0xFFFAFAFA)
    val borderShadowColorStart = Color(0xFFD5D5D5)
    val borderShadowSize = 1.dp.toPx()
    val shadowOffset = 2.dp.toPx()

    val handleColor = Color.Black
    val handleWidth = 2.dp.toPx()

    val hourDegree by animateFloatAsState(hourHandle.toFloat() * 360f / 12,
        tween(speed.duration))
    val minuteDegree by animateFloatAsState(minuteHandle.toFloat() * 360f / 12,
        tween(speed.duration))
    Canvas(modifier = modifier.fillMaxSize(), onDraw = {
        drawCircle(borderShadowColorStart,
            style = Stroke(borderShadowSize),
            center = this.center + Offset(-1 * shadowOffset, shadowOffset))
        drawCircle(borderColor,
            style = Stroke(borderSize))
        drawHandle(hourDegree, handleColor, borderSize, handleWidth)
        drawHandle(minuteDegree, handleColor, borderSize, handleWidth)
    })
}
private fun DrawScope.drawHandle(
    hourDegree: Float,
    handleColor: Color,
    borderSize: Float,
    handleWidth: Float,
) {
    drawContext.canvas.withSave {
        drawContext.transform.rotate(hourDegree)
        drawLine(handleColor,
            center.copy(y = center.y + (handleWidth / 3)),
            drawContext.size.center.copy(y = center.y - (handleWidth / 2) - (size.minDimension / 2) + borderSize),
            strokeWidth = handleWidth)
    }
}

@Preview
@Composable
private fun SmallClockPreview() {
    SmallClock(hourHandle = 3, minuteHandle = 30, speed = ClockSpeed.Slow)
}
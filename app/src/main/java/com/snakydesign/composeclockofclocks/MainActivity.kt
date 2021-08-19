package com.snakydesign.composeclockofclocks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceEvenly
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.withSave
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.snakydesign.composeclockofclocks.ui.LittleClockTime
import com.snakydesign.composeclockofclocks.ui.clocks.One
import com.snakydesign.composeclockofclocks.ui.clocks.Two
import com.snakydesign.composeclockofclocks.ui.theme.ComposeClockOfClocksTheme
import com.snakydesign.composeclockofclocks.ui.toPx

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClockOfClocksPreview()
        }
    }

    @Preview
    @Composable
    private fun ClockOfClocksPreview() {
        ComposeClockOfClocksTheme {
            // A surface container using the 'background' color from the theme
            Surface(modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background) {
                var time by remember { mutableStateOf(One) }
                Clock(Two)
            }
        }
    }

    @Composable
    fun Clock(times: Array<LittleClockTime>, modifier: Modifier = Modifier) {
        if (times.size != 24) return
        Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly) {
            (0..5).forEach { row ->
                Row(Modifier
                    .fillMaxSize()
                    .weight(1f), horizontalArrangement = SpaceEvenly) {
                    (0..3).forEach { column ->

                        val item = times[(row * 4) + column]
                        SmallClock(hourHandle = item.firstHour,
                            minuteHandle = item.secondHour,
                            Modifier.weight(1f).aspectRatio(1f))
                    }
                }
            }
        }
    }

    @Composable
    private fun SmallClock(hourHandle: Int, minuteHandle: Int, modifier: Modifier = Modifier) {
        val borderSize = 8.dp.toPx()
        val borderColor = Color(0xFFFAFAFA)
        val borderShadowColorStart = Color(0xFFD5D5D5)
        val borderShadowSize = 1.dp.toPx()
        val shadowOffset = 4.dp.toPx()

        val handleColor = Color.Black
        val handleWidth = 6.dp.toPx()

        val hourDegree by animateFloatAsState(hourHandle.toFloat() * 360f / 12)
        val minuteDegree by animateFloatAsState(minuteHandle.toFloat() * 360f / 12)
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
}
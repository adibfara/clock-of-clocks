package com.snakydesign.composeclockofclocks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.snakydesign.composeclockofclocks.ui.ClockSpeed
import com.snakydesign.composeclockofclocks.ui.clocks.components.NumberClock
import com.snakydesign.composeclockofclocks.ui.clocks.numbers.Separator
import com.snakydesign.composeclockofclocks.ui.firstNumber
import com.snakydesign.composeclockofclocks.ui.secondNumber
import com.snakydesign.composeclockofclocks.ui.theme.ComposeClockOfClocksTheme
import kotlinx.coroutines.delay
import java.util.*

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
            Surface(modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background) {
                Box(Modifier.fillMaxSize(), Alignment.Center) {
                    val hour = remember { mutableStateOf(0) }
                    val minute = remember { mutableStateOf(0) }
                    val second = remember { mutableStateOf(0) }
                    setTimes(hour, minute, second)
                    LaunchedEffect(key1 = Unit, block = {
                        while (true) {
                            delay(100)
                            setTimes(hour, minute, second)
                        }
                    })
                    WallClock(hour.value,
                        minute.value,
                        second.value,
                        Modifier.align(Alignment.Center))
                    WallClock(hour.value,
                        minute.value,
                        second.value,
                        Modifier.align(Alignment.Center))
                    Text(text = "Clock of Clocks by TheSNAKY",
                        Modifier
                            .align(Alignment.BottomCenter)
                            .padding(16.dp))
                }
            }
        }
    }

    private fun setTimes(
        hour: MutableState<Int>,
        minute: MutableState<Int>,
        second: MutableState<Int>,
    ) {
        val calendar = Calendar.getInstance()
        hour.value = calendar.get(Calendar.HOUR_OF_DAY)
        minute.value = calendar.get(Calendar.MINUTE)
        second.value = calendar.get(Calendar.SECOND)
    }

    @Composable
    fun WallClock(hour: Int, minute: Int, second: Int, modifier: Modifier = Modifier) {
        BoxWithConstraints {
            val eachWidth = maxWidth / 5

            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {

                Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    HourClock(hour, eachWidth)
                    NumberClock(Separator, ClockSpeed.Slow, Modifier.width(eachWidth))
                    HourClock(minute, eachWidth)
                }
                Spacer(modifier = Modifier.size(16.dp))

                Row(horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()) {
                    SecondClock(second, eachWidth)

                }
            }
        }
    }

    @Composable
    private fun MainActivity.SecondClock(
        second: Int,
        eachWidth: Dp,
    ) {
        NumberClock(number = second.firstNumber(), ClockSpeed.Slow, Modifier.width(eachWidth))
        NumberClock(number = second.secondNumber(), ClockSpeed.Fast, Modifier.width(eachWidth))
    }

    @Composable
    private fun MainActivity.HourClock(
        hour: Int,
        eachWidth: Dp,
    ) {
        NumberClock(number = hour.firstNumber(), ClockSpeed.Slow, Modifier.width(eachWidth))
        NumberClock(number = hour.secondNumber(), ClockSpeed.Slow, Modifier.width(eachWidth))
    }
}
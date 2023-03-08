package cl.phobos.superheroessearch.heroDetails

import androidx.compose.foundation.layout.height
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PowerStat(statValue: String?, statName: String, color: Color) {
    var value: Float = 0F
    if (statValue != null && statValue != "null") {
        value = statValue.toFloat() / 100
    }
    Text(statName)
    LinearProgressIndicator(
        modifier = Modifier.height(12.dp), progress = value, color = color
    )
}
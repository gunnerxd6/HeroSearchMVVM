package cl.phobos.superheroessearch.heroDetails

import androidx.compose.foundation.layout.height
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PowerStat(statValue:String,statName:String,color:Color){
    Text(statName)
    LinearProgressIndicator(
        modifier= Modifier.height(12.dp),
        progress = statValue.toFloat()/100, color = color)
}
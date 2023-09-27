package com.rig.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rig.calculator.datas.BtnElements
import com.rig.calculator.ui.theme.CalculatorTheme
import com.rig.calculator.widgets.AssembledApps
import com.rig.calculator.widgets.DisplayText
import com.rig.calculator.widgets.RowRep

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                val viewmodel:MyViewModel =MyViewModel()
                MyApp(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.Black)
                    .padding(10.dp),
                    Alignment.CenterHorizontally
                ) {
                    AssembledApps(viewmodel)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewApps(){
    MyApp(modifier = Modifier, Alignment.CenterHorizontally) {
        DisplayText("0")
        RowRep(
            elementList = BtnElements.nestedListElements,
            exceptionList = BtnElements.compareList
        , state = "0")
    }
}






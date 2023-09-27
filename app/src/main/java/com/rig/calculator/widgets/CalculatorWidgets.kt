package com.rig.calculator.widgets

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rig.calculator.MyViewModel
import com.rig.calculator.datas.BtnElements


@Preview
@Composable
fun Btns(element:String="4",
         color: Color = Color.DarkGray,
         x:Int=80, y:Int=80,
         fontColor:Color=Color.White,
       padding:Int=3
         , viewModel: MyViewModel=MyViewModel(),
         onclick: (String) -> Unit = {},
         state: String = "4"
        ){
    Column(modifier = Modifier
        .padding(padding.dp)
        .clip(shape = CircleShape)
        .height(x.dp)
        .width(y.dp)
        .background(color)
        .clickable
        {
            if (element == "=") {
                viewModel.evalFunction(state)
            } else if (element == "AC") {
                viewModel.evalFunction("0")
                viewModel.valueNumber.value = "0"
                onclick("")
            }
            else {
                onclick(element)
            }

        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = element, fontSize = 30.sp, color = fontColor)
    }
}

@Preview
@Composable
fun AssembledApps(viewModel: MyViewModel= MyViewModel()){
    var state = remember {
        mutableStateOf("0")
    }
    Column(horizontalAlignment =  Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(120.dp))
        DisplayText("Eval: "+state.value.toString())
        DisplayText("Result: "+viewModel.valueNumber.value)
        RowRep(
            elementList = BtnElements.nestedListElements,
            exceptionList = BtnElements.compareList,
            viewModel = viewModel
        , onclick = {
               if(it == ""){
                   state.value = 0.toString()
               }
                state.value += it
            }, state = state.value)
    }
}


@Preview
@Composable
fun DisplayText(element:String="0"){
    Surface(modifier = Modifier
        .fillMaxHeight(0.14f)
        .fillMaxWidth()
        .padding(top = 20.dp, bottom = 2.dp, start = 3.dp, end = 20.dp),
        color = Color.Black) {

        Column(verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End) {
            Text(text = element.toString(),
                modifier = Modifier.padding(2.dp),
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun RowRep(
    elementList: List<List<String>> = emptyList(),
    exceptionList: List<String> = emptyList(),
    color: Color = Color(0xFF333333),
    fontColor: Color = Color.White,
    width: Int = 80,
    viewModel: MyViewModel = MyViewModel(),
    onclick: (String) -> Unit = {}
    , state: String = "0"
){
   Column {
       elementList.forEach {
           Row {
               it.forEach{
                   Row {
                       if(it in exceptionList){
                           Btns(it,
                               color = Color(0xFFFF9F0A),
                               viewModel=viewModel,
                               onclick = onclick,
                               state = state)
                       }
                       else if(it in listOf("AC","+/-","%")){
                           Btns(it,
                               color=Color.LightGray,
                               fontColor = Color.Black,
                               viewModel=viewModel,
                               onclick=onclick,
                               state = state)
                       }
                       else if(it == "0"){
                           Btns(it,
                               y=167,
                               viewModel=viewModel,
                               onclick=onclick,
                               state = state)
                       }
                       else{
                           Btns(it,
                               viewModel=viewModel,
                               onclick=onclick,
                               state = state)
                       }
                   }
               }
           }
       }
   }
}


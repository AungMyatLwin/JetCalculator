package com.rig.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    horizontal: Alignment.Horizontal,
    content: @Composable () -> Unit
){
    Column(modifier=modifier, horizontalAlignment = horizontal) {
        content()
    }
}
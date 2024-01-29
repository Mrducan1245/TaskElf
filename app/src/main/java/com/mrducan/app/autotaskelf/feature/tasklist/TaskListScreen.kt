package com.mrducan.app.autotaskelf.feature.tasklist

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mrducan.app.autotaskelf.ui.component.MyButton
import com.mrducan.app.autotaskelf.ui.component.MyTextButton

@Composable
internal fun TaskListScreen(
    uiState: TaskListUiState,
    modifier: Modifier

){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (uiState){
            TaskListUiState.Loading -> MyButton(onClick = { /*TODO*/ }) {

            }
            is TaskListUiState.TaskList ->
                MyButton(onClick = { /*TODO*/ }) {

                }
            is TaskListUiState.Empty -> MyTextButton(onClick = { /*TODO*/ }) {
            }

        }

    }

}
package com.hongwei.demo.coroutinesvisualiser.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.hongwei.demo.coroutinesvisualiser.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    val viewState = viewModel.githubSampleStateFlow.collectAsState()
    val testUi = remember { mutableStateOf(true) }

    Column {
        Row {
            Button(onClick = {
                viewModel.testIoLoad()
            }) {
                Text(text = "Test Io Load")
            }
        }

        Row {
            Button(onClick = {
                testUi.value = !testUi.value
            }) {
                Text(text = testUi.value.toString())
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Gray)
        ) {
            Row {
                Text(text = "github: ")
            }
            Row {
                Text(text = viewState.value ?: "")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Red)
        ) {
            Row {
                Text(text = "firebase: ")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Magenta)
        ) {
            Row {
                Text(text = "graphQL: ")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Green)
        ) {
            Row {
                Text(text = "protobuf: ")
            }
        }
    }
}
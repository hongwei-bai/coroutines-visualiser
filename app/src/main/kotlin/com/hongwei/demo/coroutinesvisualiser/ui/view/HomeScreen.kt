package com.hongwei.demo.coroutinesvisualiser.ui.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.hongwei.demo.coroutinesvisualiser.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    Text(text = "Home")
}
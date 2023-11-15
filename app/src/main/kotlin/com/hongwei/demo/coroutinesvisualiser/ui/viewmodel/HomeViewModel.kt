package com.hongwei.demo.coroutinesvisualiser.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hongwei.demo.coroutinesvisualiser.data.repository.SampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val sampleRepository: SampleRepository
) : ViewModel() {
    val githubSampleStateFlow = sampleRepository.githubSampleDataFlow

    init {
        load()
    }

    fun testIoLoad() {
        viewModelScope.launch(Dispatchers.Main) {
            val a = "ha"
            val r = withContext(Dispatchers.IO) {
                sampleRepository.testIoLoadWithDelay(20)
            }
            val b = a + r
            Log.d("bbbb", b)
        }
    }

    private fun load() {
        viewModelScope.launch {
            sampleRepository.loadGithubSample()
        }
    }
}
package com.hongwei.demo.coroutinesvisualiser.data.repository

import com.example.fueladds.utility.Base64Utils.decodeBase64ToString
import com.hongwei.demo.coroutinesvisualiser.data.datasource.github.GithubOpenApiService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class SampleRepository @Inject constructor(
    private val githubOpenApiService: GithubOpenApiService
) {
    private val _githubSampleDataFlow = MutableStateFlow<String?>(null)
    val githubSampleDataFlow = _githubSampleDataFlow

    suspend fun testIoLoadWithDelay(second: Int): String {
        // Delay 25s
        delay(second * 1000L)

        return second.toString()
    }

    suspend fun loadGithubSample() {
        val response = try {
            githubOpenApiService.getContentMainJson()
        } catch (e: Exception) {
            null
        }
        val body = response?.body()
        if (response?.isSuccessful == true && body != null) {
            val encodedContent = body.content
            _githubSampleDataFlow.value = decodeBase64ToString(encodedContent)
        }
    }
}
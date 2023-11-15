package com.hongwei.demo.coroutinesvisualiser.data.datasource.github

import com.hongwei.demo.coroutinesvisualiser.data.datasource.github.Endpoint.CONTENT_ENDPOINT_BASE
import retrofit2.Response
import retrofit2.http.GET

interface GithubOpenApiService {
    @GET("$CONTENT_ENDPOINT_BASE/todoroot/category.json")
    suspend fun getContentMainJson(): Response<GithubOpenApiResponse>
}
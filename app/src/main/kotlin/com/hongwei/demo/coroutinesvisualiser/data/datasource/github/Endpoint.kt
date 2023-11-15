package com.hongwei.demo.coroutinesvisualiser.data.datasource.github

import com.hongwei.demo.coroutinesvisualiser.data.RemoteConfig.GITHUB_API_REPO
import com.hongwei.demo.coroutinesvisualiser.data.RemoteConfig.GITHUB_USERNAME

object Endpoint {
    const val GITHUB_API_BASE_URL = "https://api.github.com/"

    const val CONTENT_ENDPOINT_BASE =
        "/repos/$GITHUB_USERNAME/$GITHUB_API_REPO/contents"
}
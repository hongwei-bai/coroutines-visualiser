package com.hongwei.demo.coroutinesvisualiser.data.repository

import com.hongwei.demo.coroutinesvisualiser.BuildConfig
import javax.inject.Inject

class BuildConfigRepository @Inject constructor() {

    fun test() {
        val dataStorageFlavor = BuildConfig.DATA_STORAGE

    }
}
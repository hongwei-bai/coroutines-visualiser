import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    kotlin("kapt")
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.protobuf)
}

android {
    namespace = "com.hongwei.demo.coroutinesvisualiser"
    compileSdk = libs.versions.compileSdk.get().toInt()

    val staticApiToken = gradleLocalProperties(rootDir).getProperty("staticApi.token") ?: "\"ci\""
    buildTypes {
        getByName("debug") { buildConfigField("String", "staticApiToken", staticApiToken) }
        getByName("release") { buildConfigField("String", "staticApiToken", staticApiToken) }
    }

    signingConfigs {
        getByName("debug") {
            keyAlias = "appkey"
            keyPassword = "keyApp"
            storeFile = file("../key/debugKeystore.jks")
            storePassword = "keyApp"
        }
        create("release") {
            keyAlias = "appkey"
            keyPassword = "keyApp"
            storeFile = file("../key/debugKeystore.jks")
            storePassword = "keyApp"
        }
    }

    defaultConfig {
        applicationId = "com.hongwei.demo.coroutinesvisualiser"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        manifestPlaceholders["hostName"] = "www.example.com"
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }

        create("mock") {
            initWith(getByName("debug"))
            manifestPlaceholders["hostName"] = "internal.example.com"
            applicationIdSuffix = ".mock"
        }

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    flavorDimensions.add("type")
    productFlavors {
        create("github") {
            buildConfigField("String", "DATA_STORAGE", "\"github\"")
            flavorDimensions[0] = "type"
        }
        create("protobuf") {
            buildConfigField("String", "DATA_STORAGE", "\"githubprotobuf\"")
            flavorDimensions[0] = "type"
        }
        create("firebase") {
            buildConfigField("String", "DATA_STORAGE", "\"firebase\"")
            flavorDimensions[0] = "type"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.coroutines.ui)
    implementation(libs.hilt.android)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.navigation.compose)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.okhttp)
    implementation(libs.okhttpLogging)
    implementation(libs.retrofit)
    implementation(libs.retrofitGson)
    implementation(libs.protobuf)
    implementation(libs.protoc)
    kapt(libs.hilt.complier)

    testImplementation(libs.junit4)
    androidTestImplementation(libs.test.ext)
    androidTestImplementation(libs.test.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.ui.test)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
    testImplementation(libs.mockito)
}
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    alias(libs.plugins.hilt)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.ubersoftink.datingapp"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.ubersoftink.datingapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        buildConfigField(
            "String",
            "BASE_URL",
            "\"https://api.thecatapi.com/v1/\""
        )
        buildConfigField(
            "String",
            "API_KEY",
            "\"live_2LuKx38zGShWPwKTWWYT9Oem2dScbYd7zmmjc2tVNJCp7c53Rjzcj2y5Jx0e6ft7\""
        )

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.text.google.fonts)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    //Navigation
    implementation(libs.androidx.navigation.compose)

    // Retrofit
    implementation(libs.retrofit2.kotlinx.serialization.converter)
    implementation(libs.retrofit)
    implementation(libs.coil.compose)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.converter.gson)
    implementation(libs.gson)
    implementation(libs.androidx.compose.runtime.livedata)

    //Dagger-Hilt
    implementation(libs.hilt.android)
    implementation(libs.firebase.auth)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    //OkHttp
    implementation(libs.logging.interceptor)

    //Firebase
    implementation(libs.firebase.auth.ktx)
    implementation(libs.play.services.auth)
    implementation(platform(libs.firebase.bom))
    implementation (libs.play.services.auth.v2070)
    implementation (libs.play.services.auth.api.phone)
    implementation(libs.google.firebase.appcheck.playintegrity)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}
kapt {
    correctErrorTypes = true
}
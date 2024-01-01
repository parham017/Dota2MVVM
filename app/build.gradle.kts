plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")

}

android {
    namespace = "org.phash.gamingmvvmproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "org.phash.gamingmvvmproject"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    dataBinding{
        enable = true
    }
    viewBinding.isEnabled = true

}

dependencies {

    implementation("androidx.palette:palette:1.0.0")

    implementation("com.squareup.picasso:picasso:2.8")

    implementation("com.github.bumptech.glide:glide:4.16.0")

    implementation("com.github.SimformSolutionsPvtLtd:SSPullToRefresh:1.5.1")

    implementation("com.airbnb.android:lottie:6.1.0")

    implementation("com.github.aabhasr1:OtpView:v1.1.2-ktx")

    implementation("org.apache.commons:commons-text:1.9")

    implementation("com.h6ah4i.android.widget.advrecyclerview:advrecyclerview:1.0.0")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
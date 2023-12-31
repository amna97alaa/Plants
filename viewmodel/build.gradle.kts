plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.amna.viewmodel"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = Versions.javaVersion
        targetCompatibility = Versions.javaVersion
    }
    kotlinOptions {
        jvmTarget = Versions.jvmtarget
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(project(":usecase"))
    // core
    implementation(Deps.coreKtx)
    implementation("androidx.paging:paging-common-ktx:3.2.0")
    // testing
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junitExt)
    // hilt
    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)
    // lifecycle
    implementation(Deps.lifecycleViewModelKts)
    implementation(Deps.lifecycleRunTimeCompose)
    implementation(Deps.lifecycleSavedState)
    testImplementation(Deps.lifecycleRuntimeTesting)
    //paging
    implementation(Deps.pagingCommon)
}
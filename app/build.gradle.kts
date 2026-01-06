import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    signingConfigs {
        create("release") {
            storeFile = file("jks/test.jks")
            storePassword = "123456"
            keyAlias = "123456"
            keyPassword = "123456"
        }
    }
    namespace = "com.che2n3jigw.android.opensubsonicapi"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.che2n3jigw.android.opensubsonicapi"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_1_8
        }
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.android.open.subsonic.api)
//    implementation(project(":lib_open_subsonic_api"))
}

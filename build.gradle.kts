// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.dagger.hilt.android) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.devtools.ksp) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    // alias(libs.plugins.com.google.gms.google.services) apply false // Google Play Services
    // alias(libs.plugins.com.google.firebase.crashlytics) apply false // Google Play Services
}

extra.apply {
    set("appNamespace", "com.khodadad.jetpackcomposetemplate")
    set("appCompileSdkVersion", 34)
    set("appMinSdkVersion", 21)
    set("appTargetSdkVersion", 34)
    set("appVersionCode", 1)
    set("appVersionName", "1.0")
}
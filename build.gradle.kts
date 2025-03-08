// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false  // Android application plugin
    alias(libs.plugins.kotlin.android) apply false      // Kotlin plugin
    id("com.google.gms.google-services") version "4.4.2" apply false  // Google services plugin
}

buildscript {
    repositories {
        google()  // Google's Maven repository
        mavenCentral()  // Maven Central repository
    }
    dependencies {
        classpath("com.google.gms:google-services:4.4.2")  // Same version as above for consistency
    }
}

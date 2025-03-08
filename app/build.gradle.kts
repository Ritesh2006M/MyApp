plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.myapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.myapp"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"        // Using a property for Google Maps API key safely
        resValue("string", "google_maps_key",
            (project.findProperty("google_maps_api_key") ?: "").toString()
        )
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

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }

    ndkVersion = "27.0.12077973"
    buildToolsVersion = "35.0.1"
}

dependencies {
    // Firebase BoM for version management
    implementation(platform("com.google.firebase:firebase-bom:32.0.0")) // Latest version of Firebase BoM
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.android.gms:play-services-location:18.0.0")
    implementation("com.google.android.libraries.places:places:2.7.0")
    implementation("com.google.android.gms:play-services-maps:18.0.0") // Updated to the latest version

    // Optional dependencies (ensure they are compatible with your project)
    implementation("androidx.core:core-ktx:1.9.0")  // Updated version for Core KTX
    implementation("androidx.appcompat:appcompat:1.6.1")  // Updated version for AppCompat
    implementation("com.google.android.material:material:1.9.0")  // Updated version for Material Design
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")  // Updated version for ConstraintLayout
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0")  // Updated LiveData KTX version
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0")  // Updated ViewModel KTX version
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.1")  // Updated Navigation Fragment version
    implementation("androidx.navigation:navigation-ui-ktx:2.5.1")  // Updated Navigation UI version
    implementation("com.google.firebase:firebase-database-ktx:20.0.0")  // Firebase Realtime Database KTX

    // Testing libraries
    testImplementation("junit:junit:4.13.2")  // Updated version for JUnit testing
    androidTestImplementation("androidx.test.ext:junit:1.1.5")  // Updated version for AndroidJUnitRunner
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")  // Updated version for Espresso testing
}

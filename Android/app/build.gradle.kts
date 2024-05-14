plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.ungdungbanhang"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ungdungbanhang"
        minSdk = 24
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
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    implementation("com.squareup.picasso:picasso:2.71828")
    implementation("com.android.volley:volley:1.2.1")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("com.google.android.material:material:1.4.0") // Thay thế thư viện design cũ
    implementation("com.google.android.gms:play-services-maps:18.0.2")
    implementation("androidx.recyclerview:recyclerview:1.2.1") // Phiên bản ổn định thay vì alpha
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
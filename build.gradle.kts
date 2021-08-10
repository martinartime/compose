plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(SDK.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(SDK.MIN_SDK_VERSION)
        targetSdkVersion(SDK.TARGET_SDK_VERSION)

        versionCode = ComposeLibraryAndroidCoordinates.LIBRARY_VERSION_CODE
        versionName = ComposeLibraryAndroidCoordinates.LIBRARY_VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = SDK.KOTLIN_JVM_TARGET
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    lintOptions {
        isWarningsAsErrors = true
        isAbortOnError = true
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk7"))

    implementation(SupportLibs.ANDROIDX_APPCOMPAT)
    implementation(SupportLibs.ANDROIDX_CORE_KTX)

    testImplementation(TestingLib.JUNIT)

    androidTestImplementation(AndroidTestingLib.ANDROIDX_TEST_RUNNER)
    androidTestImplementation(AndroidTestingLib.ANDROIDX_TEST_EXT_JUNIT)

    // COMPOSE
    implementation(SupportLibs.ANDROIDX_COMPOSE_UI)
    implementation(SupportLibs.ANDROIDX_COMPOSE_UI_TOOLING)
    implementation(SupportLibs.ANDROIDX_COMPOSE_FOUNDATION)
    implementation(SupportLibs.ANDROIDX_COMPOSE_MATERIAL)
    //implementation(SupportLibs.ANDROIDX_COMPOSE_MATERIAL_ICONS_CORE)
    //implementation(SupportLibs.ANDROIDX_COMPOSE_MATERIAL_ICONS_EXTENDED)
    implementation(SupportLibs.ANDROIDX_COMPOSE_RUNTIME_LIVEDATA)
    implementation(SupportLibs.ANDROIDX_COMPOSE_RUNTIME_RX_JAVA)

    androidTestImplementation(AndroidTestingLib.ANDROIDX_COMPOSE_UI_TEST_JUNIT4)
}

plugins {
    id(AppPlugins.androidLib)
    id(AppPlugins.kotlin)
    id(AppPlugins.kotlinExt)
}

android {

    compileOptions.sourceCompatibility = JavaVersion.VERSION_1_8
    compileOptions.targetCompatibility = JavaVersion.VERSION_1_8
    compileSdkVersion(App.compileSdk)
    buildToolsVersion(App.buildTools)

    defaultConfig {
        minSdkVersion(App.minSdk)
        targetSdkVersion(App.targetSdk)
        versionName = App.versionName
        versionCode = App.versionCode
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

}

dependencies {
    implementation(project(AppModule.sdkBase))
    implementation(project(AppModule.sdkTest))
    implementation(Deps.kotlin)
    implementation(Deps.gson)
    implementation(Deps.dagger)
    implementation(Deps.retrofit)
    testImplementation(TestLibraries.junit)
    testImplementation(TestLibraries.mockitoKotlin)
    testImplementation(TestLibraries.kluent)
}

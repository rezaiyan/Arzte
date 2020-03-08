plugins {
    id(AppPlugins.androidApp)
    id(AppPlugins.kotlin)
    id(AppPlugins.kotlinKapt)
    id(AppPlugins.kotlinExt)
}

androidExtensions { isExperimental = true }

android {

    compileOptions.sourceCompatibility = JavaVersion.VERSION_1_8
    compileOptions.targetCompatibility = JavaVersion.VERSION_1_8
    compileSdkVersion(App.compileSdk)
    buildToolsVersion(App.buildTools)

    defaultConfig {
        testInstrumentationRunner = TestLibraries.androidJUnitRunner
        applicationId = App.id
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
    implementation(project(AppModule.data))
    implementation(project(AppModule.domain))
    implementation(Deps.kotlin)
    implementation(Deps.material)
    implementation(Deps.appcompat)
    implementation(Deps.recyclerview)
    implementation(Deps.ktx)
    kapt(Deps.daggerCompiler)
    implementation(Deps.dagger)
    implementation(Deps.retrofit)
    implementation(Deps.retrofitGson)
    implementation(Deps.gson)
    implementation(Deps.okhttp)
    implementation(Deps.okhttpInterceptor)
    testImplementation(TestLibraries.junit)
    debugImplementation(TestLibraries.fragmentTest)
    androidTestImplementation(TestLibraries.testExt)
    androidTestImplementation(TestLibraries.runner)
    androidTestImplementation(TestLibraries.espressoCore)
}

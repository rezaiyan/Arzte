object App {
    const val id = "ir.alirezaiyan.arzte"
    const val name = "Arzte"
    const val compileSdk = 29
    const val buildTools = "29.0.2"
    const val minSdk = 19
    const val targetSdk = 29
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val gradle = "3.5.3"
    const val kotlin = "1.3.10"
    const val coroutines = "1.0.1"

    const val appcompat = "1.1.0"
    const val material = "1.1.0-alpha10"
    const val recyclerview = "1.0.0"
    const val dagger = "2.11"
    const val picasso = "2.71828"
    const val okHttp = "3.12.0"
    const val okHttpInterceptor = "3.8.1"
    const val retrofit = "2.6.0"
    const val retrofitGson = "2.6.0"

    const val lifecycle = "2.2.0-alpha04"

    const val ktx = "1.0.1"

    const val junit = "4.12"
    const val testExt = "1.1.1"
    const val fragmentTest = "1.2.2"
    const val mockito = "2.18.3"
    const val assertjCore = "3.11.1"
    const val mockitoKotlin = "2.0.0-RC1"
    const val mockitoInline = "2.8.9"
    const val robolectric_version = "3.8"
    const val kluent_version = "1.14"

}


object BuildPlugins {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object AppPlugins {
    const val androidApp = "com.android.application"
    const val androidLib = "com.android.library"
    const val kotlin = "kotlin-android"
    const val kotlinExt = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
}

object AppModule {
    const val data = ":data"
    const val domain = ":domain"
    const val app = ":app"
    const val sdkBase = ":sdk-base"
}

object Deps {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"

    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"

    const val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okhttpInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpInterceptor}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}


object TestLibraries {
    const val androidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val fragmentTest = "androidx.fragment:fragment-testing:${Versions.fragmentTest}"
    const val junit = "junit:junit:${Versions.junit}"
    const val testExt = "androidx.test.ext:junit:${Versions.testExt}"
    const val runner = "androidx.test:runner:1.1.0"
    const val rules = "androidx.test:rules:1.1.0"
    const val espressoCore = "androidx.test.espresso:espresso-core:3.1.0"
    const val espressoIntent = "androidx.test.espresso:espresso-intents:3.1.0"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:3.1.0"
    const val xjunit = "androidx.test.ext:junit:1.0.0"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val assertjCore = "org.assertj:assertj-core:${Versions.assertjCore}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
    const val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.lifecycle}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric_version}"
    const val kluent = "org.amshove.kluent:kluent:${Versions.kluent_version}"
    const val retrofitMock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"
    const val okhttpMockServer = "com.squareup.okhttp3:mockwebserver:${Versions.okHttp}"

}

object App {
    val id = "ir.alirezaiyan.arzte"
    val name = "Arzte"
    val compileSdk = 29
    val buildTools = "29.0.2"
    val minSdk = 19
    val targetSdk = 29
    val versionCode = 1
    val versionName = "1.0.0"
}


object Versions {
    val gradle = "3.5.3"
    val kotlin = "1.3.50"

    val appcompat = "1.1.0"
    val material = "1.1.0-alpha10"
    val constraint = "1.1.3"
    val cardview = "1.0.0"
    val recyclerview = "1.0.0"
    val gson = "2.8.5"
    val okHttp = "3.12.0"
    val okHttpInterceptor = "3.8.1"
    val retrofit = "2.6.0"
    val retrofitGson = "2.6.0"

    val rxJava = "2.2.9"
    val rxJavaAdapter = "1.0.0"
    val rxAndroid = "2.1.1"
    val rxBinding = "2.2.0"

    val lifecycle = "2.2.0-alpha04"

    val ktx = "1.0.1"
    val timber = "4.7.1"

    val junit = "4.12"
    val testExt = "1.1.1"
    val fragmentTest = "1.2.2"
    val mockito = "2.18.3"
    val assertjCore = "3.11.1"
    val mockitoKotlin = "2.0.0-RC1"
    val mockitoInline = "2.8.9"
    val robolectric_version = "3.8"
    val kluent_version = "1.14"

}


object BuildPlugins {
    val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object AppPlugins {
    val androidApp = "com.android.application"
    val androidLib = "com.android.library"
    val kotlin = "kotlin-android"
    val kotlinExt = "kotlin-android-extensions"
}

object AppModule {
    val app = ":app"
    val sdkBase = ":sdk-base"
}

object Deps {
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    val material = "com.google.android.material:material:${Versions.material}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"

    val gson = "com.google.code.gson:gson:${Versions.gson}"

    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpInterceptor}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"

    val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    val rxBinding = "com.jakewharton.rxbinding2:rxbinding:${Versions.rxBinding}"
    val rxjavaAdapter = "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:${Versions.rxJavaAdapter}"

    val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    val lifecycleReactive = "androidx.lifecycle:lifecycle-reactivestreams:${Versions.lifecycle}"

    //etc
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}


object TestLibraries {
    val androidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
    val kotlinTest = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    val fragmentTest = "androidx.fragment:fragment-testing:${Versions.fragmentTest}"
    val junit = "junit:junit:${Versions.junit}"
    val testExt = "androidx.test.ext:junit:${Versions.testExt}"
    val jupiterApi = "org.junit.jupiter:junit-jupiter-api:${Versions.junit}"
    val jupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit}"
    val runner = "androidx.test:runner:1.1.0"
    val rules = "androidx.test:rules:1.1.0"
    val espressoCore = "androidx.test.espresso:espresso-core:3.1.0"
    val espressoIntent = "androidx.test.espresso:espresso-intents:3.1.0"
    val espressoContrib = "androidx.test.espresso:espresso-contrib:3.1.0"
    val xjunit = "androidx.test.ext:junit:1.0.0"
    val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    val assertjCore = "org.assertj:assertj-core:${Versions.assertjCore}"
    val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
    val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.lifecycle}"
    val robolectric = "org.robolectric:robolectric:${Versions.robolectric_version}"
    val kluent = "org.amshove.kluent:kluent:${Versions.kluent_version}"
    val retrofitMock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"
    val okhttpMockServer = "com.squareup.okhttp3:mockwebserver:${Versions.okHttp}"

}

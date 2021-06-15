object BaseDependencies {
    val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Dependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlin}"
    val jodaTime = "joda-time:joda-time:${Versions.jodaTime}"
    val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    val koinExt = "io.insert-koin:koin-android-ext:${Versions.koin}"
    val koinWorkManager = "io.insert-koin:koin-androidx-workmanager:${Versions.koin}"
}

object AndroidDependencies {
    val core = "androidx.core:core-ktx:${Versions.androidCore}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val material = "com.google.android.material:material:${Versions.material}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val roomRunTime = "androidx.room:room-runtime:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    val viewModelScope = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleScope = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    val dataStore = "androidx.datastore:datastore-preferences:${Versions.dataStore}"
}

object UnitTestDependencies {
    val junit = "org.junit.jupiter:junit-jupiter-api:${Versions.junit}"
    val junitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine"
    val kotestCore = "io.kotest:kotest-assertions-core:${Versions.kotest}"
    val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlin}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"
    val koin = "io.insert-koin:koin-test:${Versions.koin}"
    val androidCoreTesting = "androidx.arch.core:core-testing:${Versions.androidCoreTesting}"
    val androidCoreKtx = "androidx.test:core-ktx:${Versions.androidCoreKtx}"
    val androidUnitTestExt = "androidx.test.ext:junit:${Versions.androidUnitTestExt}"
    val room = "androidx.room:room-testing:${Versions.room}"
    val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
}
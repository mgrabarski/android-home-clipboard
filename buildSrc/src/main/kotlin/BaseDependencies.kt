object BaseDependencies {
    val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlin}"
}

object Dependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val jodaTime = "joda-time:joda-time:${Versions.jodaTime}"
}

object AndroidDependencies {
    val core = "androidx.core:core-ktx:${Versions.androidCore}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val material = "com.google.android.material:material:${Versions.material}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object UnitTestDependencies {
    val junit = "org.junit.jupiter:junit-jupiter-api:${Versions.junit}"
    val junitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine"
    val kotestCore = "io.kotest:kotest-assertions-core:${Versions.kotest}"
    val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlin}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"
}
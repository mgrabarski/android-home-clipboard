object BaseDependencies {
    val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Dependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
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
}
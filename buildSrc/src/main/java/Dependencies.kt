object Android {
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"
    const val coreKtx = "androidx.core:core-ktx:1.7.0"
    const val appcompat = "androidx.appcompat:appcompat:1.4.0"
    const val material = "com.google.android.material:material:1.4.0"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0"


}

object Moshi {
    const val adapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
    const val core = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
}

object OkHttp {
    const val bom = "com.squareup.okhttp3:okhttp-bom:4.9.3"
    const val core = "com.squareup.okhttp3:okhttp"
    const val url = "com.squareup.okhttp3:okhttp-urlconnection"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
}

object Retrofit {
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
}

object Compose {
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val junit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeActivity = "androidx.activity:activity-compose:1.3.1"
    const val navigation = "androidx.navigation:navigation-compose:2.4.2"
    const val accompanistNavigation = "com.google.accompanist:accompanist-navigation-animation:0.27.0"
}

object Coil {
    const val coil = "io.coil-kt:coil:2.2.2"
    const val compose = "io.coil-kt:coil-compose:2.2.2"
}

object Koin{
    const val compose= "io.insert-koin:koin-androidx-compose:3.2.2"
    const val android = "io.insert-koin:koin-android:3.2.2"
}

object Datastore {
    const val preferences =  "androidx.datastore:datastore-preferences:1.0.0"
}

object JUnit {
    const val test = "junit:junit:4.+"
    const val androidTest = "androidx.test.ext:junit:1.1.3"
    const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
}
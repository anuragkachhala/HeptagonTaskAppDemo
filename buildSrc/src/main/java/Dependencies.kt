object AppDependencies {
    const val gradle = "com.android.tools.build:gradle:${Version.gradle_version}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:1.4.21-2"
    const val kotlinGradle =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin_gradle_version}"
    const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:${Version.hilt_version}"
}

// core
object AndroidCore {
    const val coreKtx = "androidx.core:core-ktx:${Version.core_ktx_version}"
    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompat_version}"
    const val materialDesign = "com.google.android.material:material:${Version.material_version}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraint_layout_version}"
    const val activityKtx = "androidx.activity:activity-ktx:${Version.activity_ktx_version}"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Version.swipeRefreshLayout_version}"
}

//Lifecycle
object Lifecycle {
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle_version}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle_version}"
    const val lifecycleCommon =
        "androidx.lifecycle:lifecycle-common-java8:${Version.lifecycle_version}"
    const val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycle_ext}"
}

//Hilt
object Hilt {
    const val hiltAndroid = "com.google.dagger:hilt-android:${Version.hilt_version}"
    const val daggerCompiler = "com.google.dagger:hilt-android-compiler:${Version.hilt_version}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Version.hilt_androidx}"
    const val hiltViewModel =
        "androidx.hilt:hilt-lifecycle-viewmodel:${Version.hilt_viewModel_version}"
}

//Retrofit
object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit2_version}"
    const val retrofitConverterGson =
        "com.squareup.retrofit2:converter-gson:${Version.retrofit2_version}"
    const val okhttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Version.okhttp3_version}"
}

object Room {
    const val compiler = "androidx.room:room-compiler:2.2.6"
    const val ktx = "androidx.room:room-ktx:2.2.6"
    const val runtime = "androidx.room:room-runtime:2.2.6"
}

//Coroutines
object Coroutines {
    const val core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines_android_version}"
    const val android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines_android_version}"
}

object ImageLoading {
    const val pixplicity = "com.pixplicity.sharp:library:${Version.pixplicity_version}"
}

//Testing
object Testing {
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.1"
    const val room = "androidx.room:room-testing:2.2.6"
    const val jUnit = "junit:junit:${Version.junit}"
    const val extJUnit = "androidx.test.ext:junit:${Version.test_junit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
    const val okHttp = "com.squareup.okhttp3:mockwebserver:4.9.0"
    const val core = "androidx.arch.core:core-testing:2.1.0"
    const val truth = "com.google.truth:truth:1.1.3"
}

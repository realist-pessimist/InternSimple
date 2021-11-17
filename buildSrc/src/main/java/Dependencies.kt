import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    //Kotlin
    private const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    private const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"

    // App dependencies
    private const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    private const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    private const val material = "com.google.android.material:material:${Versions.material}"
    private const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    private const val annotation = "androidx.annotation:annotation:${Versions.androidXAnnotations}"
    private const val koinCore = "io.insert-koin:koin-android:${Versions.koin}"
    private const val koinCompat = "io.insert-koin:koin-android-compat:${Versions.koin}"
    private const val koinNavigation = "io.insert-koin:koin-androidx-navigation:${Versions.koin}"
    private const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    private const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    private const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    private const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    private const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.androidXLegacySupport}"

    // Architecture Components
    private const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.archLifecycle}"
    private const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.archLifecycle}"
    private const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    private const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    private const val fragment = "androidx.fragment:fragment:${Versions.fragment}"

    // Dependencies for local unit tests
    private const val junit = "junit:junit:${Versions.junit}"
    private const val navigationTesting = "androidx.navigation:navigation-testing:${Versions.navigation}"
    private const val junitKtx = "androidx.test.ext:junit-ktx:${Versions.androidXTestExtKotlinRunner}"
    private const val testCoreKtx = "androidx.test:core-ktx:${Versions.androidXTestCore}"
    private const val truth = "com.google.truth:truth:${Versions.truth}"

    val appLibraries = mutableListOf<String>().apply {
        add(fragment)
        add(fragmentKtx)
        add(appcompat)
        add(cardView)
        add(material)
        add(recyclerView)
        add(annotation)
        add(coroutines)
        add(retrofit)
        add(retrofitGson)
        add(glide)
        add(okhttpLogging)
        add(koinCore)
        add(koinCompat)
        add(koinNavigation)
        add(legacySupport)
        add(lifecycleViewModel)
        add(lifecycleLiveData)
        add(navigationFragment)
        add(navigationFragmentKtx)
        add(navigationUI)
    }

    val testLibraries = mutableListOf<String>().apply {
        add(junit)
        add(junitKtx)
        add(testCoreKtx)
        add(truth)
    }

    val androidTestLibraries = mutableListOf<String>().apply {
        add(junit)
        add(testCoreKtx)
        add(junitKtx)
        add(navigationTesting)
        add(annotation)
        add(legacySupport)
        add(recyclerView)
        add(appcompat)
        add(material)
    }
}

//Util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.debugImplementation (list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}
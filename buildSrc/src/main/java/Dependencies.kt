package dependencies

object Dependencies {

    private const val path = "../commonFiles/gradleScript/"
    const val dependency = "./gradleScript/dependencies.gradle"
    const val common = "${path}common.gradle"

    object ClassPaths {
        const val gradleClasspath = "com.android.tools.build:gradle:${Version.gradleVersion}"
        const val kotlinGradlePluginClasspath =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlinVersion}"
        const val dokkaPluginClasspath =
            "org.jetbrains.dokka:dokka-gradle-plugin:${Version.dokkaVeresion}"
        const val jacoco = "com.vanniktech:gradle-android-junit-jacoco-plugin:${Version.jacoco}"
    }

    object Plugins {
        const val ANDROID_APPLICATION = "com.android.application"
        const val ANDROID_LIBRARY = "com.android.library"
        const val GOOGLE_SERVICES = "com.google.gms.google-services"
        const val FIREBASE_PREF = "com.google.firebase.firebase-perf"
        const val FABRIC_IO = "io.fabric"
        const val KOTLIN_ANDROID = "kotlin-android"
        const val KOTLIN_KAPT = "kotlin-kapt"
        const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
        const val DETEKT = "io.gitlab.arturbosch.detekt"
        const val JACOCO = "com.vanniktech.android.junit.jacoco"
    }

    object Lint {
        const val detekt = "io.gitlab.arturbosch.detekt:detekt-cli:${Version.detektVersion}"
        const val ktLint = "com.pinterest:ktlint:${Version.ktLint}"
    }

    object Module {
        const val data = ":data"
        const val cache = ":cache"
        const val remote = ":remote"
        const val domain = ":domain"
        const val presentaion = ":presentation"
    }

    object Facebook {
        const val stetho = "com.facebook.stetho:stetho:${Version.stetho}"
        const val stethoNetwork = "com.facebook.stetho:stetho-okhttp3:${Version.stetho}"
    }

    object Lifecycle {
        const val extension = "android.arch.lifecycle:extensions:${Version.lifecycle}"
        const val annotation_compliler = "android.arch.lifecycle:compiler:${Version.lifecycle}"

        // ViewModel and LiveData
        const val lifeCycleExtension =
            "androidx.lifecycle:lifecycle-extensions:${Version.lifecycleVersion}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Version.glide}"
        const val annotationProcessor = "androidx.annotation:annotation:1.0.0"
        const val annotationCompiler = "com.github.bumptech.glide:compiler:${Version.glide}"
    }

    object Picasso {
        const val picasso = "com.squareup.picasso:picasso:${Version.picasso}"
    }

    object Gson {
        const val gson = "com.google.code.gson:gson:${Version.gson}"
    }

    object Kotlin {
        const val kotlin_stdlib_jdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    }

    object OkHttp3 {
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Version.retrofit_log}"
        const val okHttp3 = "com.squareup.okhttp3:okhttp:3.12.1"
    }

    object Retrofit2 {
        const val adapterRxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${Version.retrofit}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    }

    object AndroidX {
        const val fragment = "androidx.fragment:fragment:${Version.androidx}"
        const val annotation = "androidx.annotation:annotation:${Version.androidx}"
        const val core = "androidx.core:core:${Version.androidx}"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${Version.androidx_112}"
        const val materialDesign = "com.google.android.material:material:${Version.materialDesign}"
        const val support_recyclerview_v7 =
            "androidx.recyclerview:recyclerview:${Version.recyclerView}"
        const val appcompat = "androidx.appcompat:appcompat:${Version.androidx_100beta01}"
        const val vectordrawable =
            "androidx.vectordrawable:vectordrawable:${Version.androidx_100beta01}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Version.room}"
        const val rxjava2 = "androidx.room:room-rxjava2:${Version.room}"
        const val annotationProcessor = "androidx.room:room-compiler:${Version.room}"
    }

    object RxJava {
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Version.rxAndroid}"
        const val rxjava2 = "io.reactivex.rxjava2:rxjava:${Version.rx}"
        const val rxrelay2 = "com.jakewharton.rxrelay2:rxrelay:${Version.rxRelay}"
        const val rxBinding = "com.jakewharton.rxbinding3:rxbinding:${Version.rxBinding}"
    }

    object Dagger {
        const val dagger2 = "com.google.dagger:dagger:${Version.dagger2}"
        const val daggerAndroid = "com.google.dagger:dagger-android:${Version.dagger2}"
        const val daggerAndroidSupport =
            "com.google.dagger:dagger-android-support:${Version.dagger2}"
        const val processor = "com.google.dagger:dagger-android-processor:${Version.dagger2}"
        const val compiler = "com.google.dagger:dagger-compiler:${Version.dagger2}"
    }

    object Test {
        const val test_junit = "junit:junit:${Version.junit}"
        const val android_test_espresso_core =
            "androidx.test.espresso:espresso-core:${Version.espresso}"
        const val android_test_room = "android.arch.persistence.room:testing:${Version.room}"
        const val testing_core_testing = "android.arch.core:core-testing:${Version.lifecycle}"
        const val android_test_rules = "androidx.test:rules:${Version.rules}"
        const val android_test_runner = "androidx.test:runner:${Version.runner}"
        const val mockito = "org.mockito:mockito-core:${Version.mockito}"
        const val assert_j = "org.assertj:assertj-core:${Version.assertJVersion}"
        const val roboElectric = "org.robolectric:robolectric:${Version.roboElectric}"
    }

    object Support {
        const val supportV4 = "com.android.support:support-v4:${Version.supportLib}"
    }

    const val javax = "javax.inject:javax.inject:${Version.javaxInject}"
    const val javaxjsr250 = "javax.annotation:jsr250-api:${Version.javaxAnnotation}"
    const val parceler = "org.parceler:parceler-api:${Version.parcelerVersion}"
    const val parcelerProcessor = "org.parceler:parceler-api:${Version.parcelerVersion}"
}

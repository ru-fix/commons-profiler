import org.gradle.kotlin.dsl.*


plugins {
    java
    kotlin("jvm")
}

dependencies {
    /**
     * Runtime
     */
    compile(Libs.slf4j_api)
    compile(Libs.kotlin_jdk8)

    /**
     * Tests
     */

    testImplementation(Libs.junit_api)
    testRuntimeOnly(Libs.junit_engine)

    testCompile(Libs.kotlin_stdlib)
    testCompile(Libs.kotlin_reflect)
    testCompile(Libs.kotlinx_coroutines)

    testCompile(Libs.slf4j_simple)
    testCompile(Libs.hamcrest)
}



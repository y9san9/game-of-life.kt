plugins {
  alias(libs.plugins.kotlin.multiplatform)
}

repositories {
  mavenCentral()
}

kotlin {
  jvm()
}

dependencies {
  commonMainApi(projects.geometry)
  commonTestImplementation(libs.kotlin.test)
}

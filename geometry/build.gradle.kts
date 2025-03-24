plugins {
  alias(libs.plugins.kotlin.multiplatform)
}

repositories {
  mavenCentral()
}

kotlin {
  jvm()

  linuxArm64()
  linuxX64()

  macosArm64()
  macosX64()

  mingwX64()
}


plugins {
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.jetbrains.compose)
  alias(libs.plugins.compose.compiler)
}

kotlin {
  jvm {
    binaries {
      executable {
        mainClass = "me.y9san9.gol.mosaic.MosaicAppKt"
      }
    }
  }

  val linuxArm64 = linuxArm64()
  val linuxX64 = linuxX64()

  val macosArm64 = macosArm64()
  val macosX64 = macosX64()

  val mingwX64 = mingwX64()

  val nativeTargets = listOf(
    linuxArm64, linuxX64,
    macosArm64, macosX64,
    mingwX64,
  )

  configure(nativeTargets) {
    binaries {
      executable {
        entryPoint = "me.y9san9.gol.mosaic"
      }
    }
  }
}

repositories {
  mavenCentral()
  google()
}

dependencies {
  commonMainImplementation(projects.engine)
  commonMainImplementation(libs.mosaic.runtime)
  commonMainImplementation(libs.mosaic.terminal)
  commonMainImplementation(libs.kotlinx.coroutines.core)
}

plugins {
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.jetbrains.compose)
  alias(libs.plugins.compose.compiler)
  application
}

repositories {
  mavenCentral()
  google()
}

application {
  mainClass = "me.y9san9.gol.mosaic.MosaicAppKt"
}

dependencies {
  implementation(projects.engine)
  implementation(libs.mosaic.runtime)
  implementation(libs.mosaic.terminal)
  implementation(libs.kotlinx.coroutines.core)
}

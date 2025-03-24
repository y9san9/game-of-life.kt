package me.y9san9.gol.mosaic

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import com.jakewharton.mosaic.runMosaic
import kotlinx.coroutines.delay

suspend fun main() = runMosaic {
  val config = remember { MosaicGameOfLife() }
  var game by remember { mutableStateOf(config.seed) }

  LaunchedEffect(Unit) {
    val tickDelay = 1_000L / config.tps
    while (true) {
      game = game.tick()
      delay(tickDelay)
    }
  }

  GameOfLifeContent(config, game)
}

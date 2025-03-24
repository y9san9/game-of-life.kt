package me.y9san9.gol.mosaic

import me.y9san9.gol.engine.GameOfLife
import me.y9san9.gol.geometry.GameField
import me.y9san9.gol.geometry.buildGameField
import me.y9san9.gol.geometry.set

data class MosaicGameOfLife(
  val aliveString: String = "██",
  val deadString: String = "  ",
  val tps: Int = 10,
  val seed: GameOfLife = GameOfLife(
    buildGameField {
      this[0, 0] = Unit
      this[0, 1] = Unit
      this[-1, 0] = Unit
      this[0, -1] = Unit
      this[1, -1] = Unit
    }
  ),
)


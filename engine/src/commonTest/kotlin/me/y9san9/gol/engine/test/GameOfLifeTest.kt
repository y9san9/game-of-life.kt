package me.y9san9.gol.engine.test

import kotlin.test.Test
import kotlin.test.assertEquals
import me.y9san9.gol.engine.GameOfLife
import me.y9san9.gol.geometry.buildGameField
import me.y9san9.gol.geometry.set

class GameOfLifeTest {
  @Test
  fun testTick() {
    val field = buildGameField {
      this[0, 0] = Unit
      this[0, 1] = Unit
      this[-1, 0] = Unit
      this[0, -1] = Unit
      this[1, -1] = Unit
    }

    val game = GameOfLife(field)

    val nextField = buildGameField {
      this[-1, 0] = Unit
      this[0, 1] = Unit
      this[-1, -1] = Unit
      this[0, -1] = Unit
      this[1, -1] = Unit
      this[-1, 1] = Unit
    }

    val nextGame = game.tick()

    assertEquals(nextField, nextGame.field)
  }

  @Test
  fun test10Ticks() {
    val field = buildGameField {
      this[0, 0] = Unit
      this[0, 1] = Unit
      this[-1, 0] = Unit
      this[0, -1] = Unit
      this[1, -1] = Unit
    }

    val game = GameOfLife(field)

    val nextField = buildGameField {
      this[0, 1] = Unit
      this[0, 2] = Unit
      this[0, 3] = Unit
      this[-1, 1] = Unit
      this[-2, 1] = Unit
      this[-2, 0] = Unit
      this[-3, 0] = Unit
      this[-3, -1] = Unit
      this[-4, -1] = Unit
      this[-3, -2] = Unit
      this[-2, -2] = Unit
    }

    var nextGame = game
    repeat(10) {
      nextGame = nextGame.tick()
    }

    assertEquals(nextField, nextGame.field)
  }
}


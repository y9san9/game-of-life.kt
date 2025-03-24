package me.y9san9.gol.mosaic

import androidx.compose.runtime.Composable
import com.jakewharton.mosaic.LocalTerminal
import com.jakewharton.mosaic.ui.Column
import com.jakewharton.mosaic.ui.Row
import com.jakewharton.mosaic.ui.Text
import me.y9san9.gol.engine.GameOfLife
import me.y9san9.gol.geometry.Coordinate

@Composable
fun GameOfLifeContent(
  config: MosaicGameOfLife,
  game: GameOfLife,
) {
  val (width, height) = LocalTerminal.current.size

  val widthCoerced = width / 2

  Column {
    repeat(height) { column ->
      Row {
        repeat(widthCoerced) { row ->
          val centeredCoordinate = Coordinate(
            x = row - widthCoerced / 2,
            y = column - height / 2,
          )
          val isAlive = game.isAlive(centeredCoordinate)
          val string = if (isAlive) config.aliveString else config.deadString
          Text(string)
        }
      }
    }
  }
}
